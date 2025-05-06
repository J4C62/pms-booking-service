package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventsSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.CloudEventSerde;
import io.cloudevents.CloudEvent;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Component
public class BookingTopology {
  @Autowired
  public void process(StreamsBuilder streamsBuilder, ObjectMapper mapper) {
    KStream<String, CloudEvent> stream =
        streamsBuilder.stream(
            List.of("booking.created", "booking.updated", "booking.cancelled"),
            Consumed.with(Serdes.String(), new CloudEventSerde()));
    stream
        .map(getFailedToDeserializeBookingEvent(mapper))
        .groupByKey(Grouped.with(new JsonSerde<>(BookingId.class), new BookingEventSerde()))
        .aggregate(
            () -> new BookingEvents(List.of()),
            (key, newEvent, aggregate) -> aggregate.append(newEvent),
            Materialized.<BookingId, BookingEvents, KeyValueStore<Bytes, byte[]>>as(
                    "booking-events-store")
                .withKeySerde(new JsonSerde<>(BookingId.class))
                .withValueSerde(new BookingEventsSerde()));
  }

  private KeyValueMapper<String, CloudEvent, KeyValue<BookingId, BookingEvent>>
      getFailedToDeserializeBookingEvent(ObjectMapper mapper) {
    return (key, value) -> {
      try {
        var eventType = value.getType();
        var json =
            new String(Objects.requireNonNull(value.getData()).toBytes(), StandardCharsets.UTF_8);

        Class<? extends BookingEvent> eventClass = resolveType(eventType);
        BookingEvent event = mapper.readValue(json, eventClass);

        return KeyValue.pair(event.bookingId(), event);

      } catch (Exception e) {
        throw new RuntimeException("Failed to deserialize BookingEvent", e);
      }
    };
  }

  private Class<? extends BookingEvent> resolveType(String eventType) {
    return switch (eventType) {
      case "booking.created" -> BookingCreatedEvent.class;
      case "booking.cancelled" -> BookingCancelledEvent.class;
      case "booking.updated" -> BookingUpdateEvent.class;
      default -> throw new IllegalArgumentException("Unknown event type: " + eventType);
    };
  }
}

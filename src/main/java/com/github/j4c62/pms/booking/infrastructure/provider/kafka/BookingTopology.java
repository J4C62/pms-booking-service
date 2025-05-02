package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import io.cloudevents.CloudEvent;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingTopology {

  @Autowired
  public void process(StreamsBuilder streamsBuilder) {
    KStream<String, CloudEvent> stream =
        streamsBuilder.stream(
            List.of("booking.created", "booking.updated", "booking.cancelled"),
            Consumed.with(Serdes.String(), new CloudEventSerde()));

    stream
        .mapValues(
            value -> {
              try {
                String eventType = value.getType();

                String json =
                    new String(
                        Objects.requireNonNull(value.getData()).toBytes(), StandardCharsets.UTF_8);

                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                JsonNode jsonNode = mapper.readTree(json);

                Class<? extends BookingEvent> eventClass = resolveType(eventType);

                return mapper.treeToValue(jsonNode, eventClass);

              } catch (Exception e) {
                throw new RuntimeException("Failed to deserialize BookingEvent", e);
              }
            })
        .groupByKey()
        .aggregate(
            () -> new BookingEvents(List.of()),
            (key, newEvent, aggregate) -> aggregate.append(newEvent),
            Materialized.<String, BookingEvents, KeyValueStore<Bytes, byte[]>>as(
                    "booking-events-store")
                .withKeySerde(Serdes.String())
                .withValueSerde(new BookingEventsSerde()));
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

package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.deserializer.BookingEventDeserializer;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventsSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.CloudEventSerde;
import io.cloudevents.CloudEvent;
import java.util.List;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Component
public class BookingTopology {
  @Value("${application.booking.kafka.store-name}")
  String storeName;

  @Autowired
  public void buildTopology(
      StreamsBuilder builder, BookingEventDeserializer deserializer, ObjectMapper objectMapper) {
    KStream<String, CloudEvent> stream =
        builder.stream(
            List.of("booking.created", "booking.updated", "booking.cancelled", "booking.confirmed"),
            Consumed.with(Serdes.String(), new CloudEventSerde()));

    stream
        .map(
            (key, cloudEvent) -> {
              var event = deserializer.deserialize(cloudEvent);
              return KeyValue.pair(event.bookingId(), event);
            })
        .groupByKey(
            Grouped.with(new JsonSerde<>(BookingId.class), new BookingEventSerde(objectMapper)))
        .aggregate(
            BookingEvents::empty,
            (key, newEvent, aggregate) -> aggregate.append(newEvent),
            Materialized.<BookingId, BookingEvents, KeyValueStore<Bytes, byte[]>>as(storeName)
                .withKeySerde(new JsonSerde<>(BookingId.class))
                .withValueSerde(new BookingEventsSerde()));
  }
}

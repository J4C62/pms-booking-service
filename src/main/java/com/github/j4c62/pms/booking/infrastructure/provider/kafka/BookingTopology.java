package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventsSerde;
import java.util.function.Function;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
public class BookingTopology {
  @Value("${application.booking.kafka.store-name}")
  String storeName;

  @Bean
  public Function<KStream<String, BookingEvent>, KStream<BookingId, BookingEvents>>
      processBookingEvents(
          Serde<BookingEvent> bookingEventSerde, Serde<BookingEvents> bookingEventsSerde) {

    return input ->
        input
            .filter((key, value) -> value != null)
            .map((key, cloudEvent) -> KeyValue.pair(cloudEvent.bookingId(), cloudEvent))
            .groupByKey(Grouped.with(new JsonSerde<>(BookingId.class), bookingEventSerde))
            .aggregate(
                BookingEvents::empty,
                (key, newEvent, aggregate) -> aggregate.append(newEvent),
                Materialized.<BookingId, BookingEvents, KeyValueStore<Bytes, byte[]>>as(storeName)
                    .withKeySerde(new JsonSerde<>(BookingId.class))
                    .withValueSerde(bookingEventsSerde))
            .toStream();
  }

  @Bean
  public Serde<BookingEvent> bookingEventSerde(ObjectMapper objectMapper) {
    return new BookingEventSerde(objectMapper);
  }

  @Bean
  public Serde<BookingEvents> bookingEventsSerde() {
    return new BookingEventsSerde();
  }
}

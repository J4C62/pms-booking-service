package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventSerde;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde.BookingEventsSerde;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
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

/**
 * Kafka Streams topology configuration for processing booking events.
 *
 * <p>This configuration defines the stream processing logic to consume, aggregate, and store
 * booking events keyed by {@link BookingId} in a state store. It also declares the required SerDes
 * for {@link BookingEvent} and {@link BookingEvents} to enable Kafka serialization and
 * deserialization.
 *
 * <p>The main processing function performs the following steps:
 *
 * <ul>
 *   <li>Filters out null events
 *   <li>Re-keys the stream by bookingId
 *   <li>Groups events by bookingId
 *   <li>Aggregates events into {@link BookingEvents}
 *   <li>Materializes the aggregated results into a Kafka state store
 *   <li>Converts the aggregated state back into a stream for downstream processing
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-02
 */
@Configuration
@Slf4j
public class BookingTopology {
  @Value("${application.booking.kafka.store-name}")
  String storeName;

  /**
   * Defines the Kafka Streams processing function that aggregates booking events by bookingId.
   *
   * @param bookingEventSerde Serde for {@link BookingEvent} used in deserialization and
   *     serialization
   * @param bookingEventsSerde Serde for {@link BookingEvents} used for state store serialization
   * @return a function transforming an input KStream keyed by String to an output KStream keyed by
   *     BookingId with aggregated BookingEvents
   * @author Jose Antonio (J4c62)
   * @since 2025-05-14
   */
  @Bean
  @WithSpan("[store] Topology - Kafka stream store")
  public Function<KStream<String, BookingEvent>, KStream<BookingId, BookingEvents>>
      processBookingEvents(
          Serde<BookingEvent> bookingEventSerde, Serde<BookingEvents> bookingEventsSerde) {

    return input ->
        input
            .map((key, cloudEvent) -> KeyValue.pair(cloudEvent.bookingId(), cloudEvent))
            .groupByKey(Grouped.with(new JsonSerde<>(BookingId.class), bookingEventSerde))
            .aggregate(
                BookingEvents::empty,
                (key, newEvent, aggregate) -> {
                  if (log.isInfoEnabled()) {
                    log.info(
                        "[store] Appended event: {} with booking_id:{}",
                        newEvent.eventType(),
                        key.value());
                  }
                  if (log.isDebugEnabled()) {
                    log.debug(
                        "[store] Appended booking_type:{} with booking_id:{} to aggregate:{}",
                        newEvent,
                        key,
                        aggregate);
                  }
                  return aggregate.append(newEvent);
                },
                Materialized.<BookingId, BookingEvents, KeyValueStore<Bytes, byte[]>>as(storeName)
                    .withKeySerde(new JsonSerde<>(BookingId.class))
                    .withValueSerde(bookingEventsSerde))
            .toStream();
  }

  /**
   * Provides a Serde for {@link BookingEvent} using a custom {@link BookingEventSerde}.
   *
   * @param objectMapper the Jackson {@link ObjectMapper} to use for serialization
   * @return a {@link Serde} for BookingEvent
   * @author Jose Antonio (J4c62)
   * @since 2025-05-14
   */
  @Bean
  public Serde<BookingEvent> bookingEventSerde(ObjectMapper objectMapper) {
    return new BookingEventSerde(objectMapper);
  }

  /**
   * Provides a Serde for {@link BookingEvents}.
   *
   * @return a {@link Serde} for BookingEvents
   * @author Jose Antonio (J4c62)
   * @since 2025-05-14
   */
  @Bean
  public Serde<BookingEvents> bookingEventsSerde() {
    return new BookingEventsSerde();
  }
}

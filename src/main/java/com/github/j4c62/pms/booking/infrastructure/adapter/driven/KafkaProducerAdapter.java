package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

/**
 * Kafka-based implementation of the {@link BookingEventPublisher} interface.
 *
 * <p>This service is responsible for publishing {@link BookingEvent} instances to a Kafka topic via
 * Spring Cloud Stream's {@link StreamBridge}. It decouples domain logic from messaging
 * infrastructure.
 *
 * <p>The event is sent to the output binding named {@code bookingEventSupplier-out-0}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-18
 */
@Service
@RequiredArgsConstructor
public class KafkaProducerAdapter implements BookingEventPublisher {
  private final StreamBridge streamBridge;

  /**
   * Publishes the given {@link BookingEvent} to Kafka using Spring Cloud Stream.
   *
   * @param bookingEvent the event to publish; must not be {@code null}
   * @author Jose Antonio (J4c62)
   * @since 2025-04-18
   */
  @Override
  public void publish(@NonNull BookingEvent bookingEvent) {
    streamBridge.send("bookingEventSupplier-out-0", bookingEvent);
  }
}

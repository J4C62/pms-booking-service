package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
  @WithSpan("[publisher] Publish Event - Stream Bridge send")
  public void publish(@NonNull BookingEvent bookingEvent) {
    var current = Span.current();
    current.setAttribute("booking.id", String.valueOf(bookingEvent.bookingId().value()));
    current.setAttribute("booking.at", String.valueOf(bookingEvent.occurredAt()));

    if (!streamBridge.send("bookingEventSupplier-out-0", bookingEvent)) {
      if (log.isWarnEnabled()) {
        log.warn(
            "[publisher] Event with booking_id:{} not published", bookingEvent.bookingId().value());
      }
    }
    if (log.isInfoEnabled()) {
      log.info(
          "[publisher] BookingEvent published: booking_type:{}, booking_id:{}",
          bookingEvent.eventType(),
          bookingEvent.bookingId().value());
    }
    if (log.isDebugEnabled()) {
      log.debug(
          "[publisher] BookingEvent published: booking_type:{}, booking_id:{}, occurred_at:{}",
          bookingEvent.eventType(),
          bookingEvent.bookingId().value(),
          bookingEvent.occurredAt());
    }
  }
}

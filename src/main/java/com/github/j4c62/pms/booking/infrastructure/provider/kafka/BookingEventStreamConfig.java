package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * Spring configuration class for configuring the booking event stream.
 *
 * <p>Defines a Spring Cloud Stream {@link Function} bean that converts {@link BookingEvent}
 * instances into CloudEvents-compliant {@link Message} objects with the necessary headers for
 * event-driven communication.
 *
 * <p>This configuration enables integration with messaging middleware, ensuring that booking events
 * are published with standard CloudEvents metadata, such as event ID, type, source, spec version,
 * and timestamp.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-14
 */
@Configuration
public class BookingEventStreamConfig {

  /**
   * Supplier function that transforms a {@link BookingEvent} into a CloudEvents formatted {@link
   * Message} with appropriate headers.
   *
   * @return a function that wraps booking events into messages ready for publication
   * @author Jose Antonio (J4c62)
   * @since 2025-05-14
   */
  @Bean
  public Function<BookingEvent, Message<BookingEvent>> bookingEventSupplier() {
    return bookingEvent ->
        withPayload(bookingEvent)
            .setHeader("ce-id", UUID.randomUUID().toString())
            .setHeader("ce-type", bookingEvent.eventType().getEventType())
            .setHeader("ce-source", "booking-service")
            .setHeader("ce-specversion", "1.0")
            .setHeader("ce-time", OffsetDateTime.now().toString())
            .setHeader(MessageHeaders.CONTENT_TYPE, "application/json")
            .build();
  }
}

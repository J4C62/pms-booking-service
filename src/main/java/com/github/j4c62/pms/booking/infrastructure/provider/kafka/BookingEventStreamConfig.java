package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
public class BookingEventStreamConfig {

  @Bean
  public Function<BookingEvent, Message<BookingEvent>> bookingEventSupplier() {
    return bookingEvent ->
        MessageBuilder.withPayload(bookingEvent)
            .setHeader("ce-id", UUID.randomUUID().toString())
            .setHeader("ce-type", bookingEvent.eventType().getEventType())
            .setHeader("ce-source", "booking-service")
            .setHeader("ce-specversion", "1.0")
            .setHeader("ce-time", OffsetDateTime.now().toString())
            .setHeader(MessageHeaders.CONTENT_TYPE, "application/json")
            .build();
  }
}

package com.github.j4c62.pms.booking.infrastructure.config;

import com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.KafkaAdapter;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.CloudEventAssembler;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@TestConfiguration
@Import({KafkaAdapter.class, CloudEventAssembler.class, JacksonAutoConfiguration.class})
public class FixtureKafka {
  @Bean
  public BookingDates getBookingDates() {
    return new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
  }

  @Bean
  public GuestId getGuestId() {
    return new GuestId(UUID.randomUUID());
  }

  @Bean
  public PropertyId getPropertyId() {
    return new PropertyId(UUID.randomUUID());
  }

  @Bean
  public BookingId getBookingId() {
    return new BookingId(UUID.randomUUID());
  }

  @Bean
  @Qualifier("bookingCreated")
  public BookingEvent createBookingEvent(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new BookingCreatedEvent(
        bookingId,
        propertyId,
        guestId,
        bookingDates,
        Instant.now(),
        BookingEventType.BOOKING_CREATED);
  }

  @Bean
  @Qualifier("bookingUpdated")
  public BookingEvent updateBookingEvent(BookingId bookingId, BookingDates bookingDates) {
    return BookingEventFactory.createBookingEvent(bookingId, bookingDates);
  }

  @Bean
  @Qualifier("bookingCancel")
  public BookingEvent cancelBookingEvent(BookingId bookingId) {
    return BookingEventFactory.createBookingEvent(bookingId);
  }

  @Component
  public record SetUpFixtureIntegration(
      BookingEventPublisher bookingEventPublisher,
      @Qualifier("bookingCreated") BookingEvent createBookingEvent,
      @Qualifier("bookingUpdated") BookingEvent updateBookingEvent,
      @Qualifier("bookingCancel") BookingEvent cancelBookingEvent) {}
}

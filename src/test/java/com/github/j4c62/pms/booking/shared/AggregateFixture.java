package com.github.j4c62.pms.booking.shared;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createConfirmedBookingEvent;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AggregateFixture {

  @Bean
  public BookingId bookingId() {
    return BookingId.of(UUID.randomUUID());
  }

  @Bean
  public PropertyId propertyId() {
    return PropertyId.of(UUID.randomUUID());
  }

  @Bean
  public GuestId guestId() {
    return GuestId.of(UUID.randomUUID());
  }

  @Bean
  public BookingDates bookingDates() {
    return BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
  }

  @Bean
  @Qualifier("bookingCreatedEvent")
  public BookingEvent bookingCreatedEvent(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return createBookingEvent(bookingId, propertyId, guestId, bookingDates);
  }

  @Bean
  @Qualifier("bookingCancelledEvent")
  public BookingEvent bookingCancelledEvent(BookingId bookingId) {
    return BookingEventFactory.createCancelledBookingEvent(bookingId);
  }

  @Bean
  @Qualifier("bookingUpdateEvent")
  public BookingEvent bookingUpdateEvent(BookingId bookingId, BookingDates bookingDates) {
    return BookingEventFactory.createUpdateBookingEvent(bookingId, bookingDates);
  }

  @Bean
  @Qualifier("bookingConfirmedEvent")
  public BookingEvent bookingConfirmedEvent(BookingId bookingId) {
    return createConfirmedBookingEvent(bookingId);
  }

  @Bean
  public BookingEvents bookingEvents(@Qualifier("bookingCreatedEvent") BookingEvent createdEvent) {
    return BookingEvents.of(List.of(createdEvent));
  }

  @Bean
  public BookingAggregate bookingAggregate(
      BookingId bookingId,
      PropertyId propertyId,
      GuestId guestId,
      BookingDates bookingDates,
      BookingEvents bookingEvents) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, bookingDates, BookingStatus.PENDING, bookingEvents);
  }

  private BookingEvent createBookingEvent(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new BookingCreatedEvent(
        bookingId,
        propertyId,
        guestId,
        bookingDates,
        Instant.now(),
        BookingEventType.BOOKING_CREATED);
  }
}

package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.time.Instant;

public final class BookingEventFactory {

  private BookingEventFactory() {}

  public static BookingEvent createUpdateBookingEvent(BookingId bookingId, BookingDates newDates) {
    return new BookingUpdateEvent(
        bookingId, newDates, Instant.now(), BookingEventType.BOOKING_UPDATED);
  }

  public static BookingEvent createCancelledBookingEvent(BookingId bookingId) {
    return new BookingCancelledEvent(bookingId, Instant.now(), BookingEventType.BOOKING_CANCELLED);
  }

  public static BookingEvent createConfirmedBookingEvent(BookingId bookingId) {
    return new BookingConfirmedEvent(bookingId, BookingEventType.BOOKING_CONFIRMED, Instant.now());
  }

  public static BookingEvent createBookingEvent(BookingAggregate aggregate) {
    return new BookingCreatedEvent(
        aggregate.bookingId(),
        aggregate.propertyId(),
        aggregate.guestId(),
        aggregate.bookingDates(),
        Instant.now(),
        BookingEventType.BOOKING_CREATED);
  }
}

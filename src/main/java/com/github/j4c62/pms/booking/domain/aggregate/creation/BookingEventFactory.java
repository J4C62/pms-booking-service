package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.time.Instant;

public final class BookingEventFactory {

  private BookingEventFactory() {}

  public static BookingEvent createBookingEvent(BookingId bookingId, BookingDates newDates) {
    return new BookingUpdateEvent(
        bookingId, newDates, Instant.now(), BookingEventType.BOOKING_UPDATED);
  }

  public static BookingEvent createBookingEvent(BookingId bookingId) {
    return new BookingCancelledEvent(bookingId, Instant.now(), BookingEventType.BOOKING_CANCELLED);
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

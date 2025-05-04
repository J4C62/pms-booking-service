package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;

public final class BookingEventFactory {

  private BookingEventFactory() {}

  public static BookingEvent createBookingEvent(BookingId bookingId, BookingDates newDates) {
    return new BookingUpdateEvent(bookingId, newDates, null, BookingEventType.BOOKING_UPDATED);
  }

  public static BookingEvent createBookingEvent(BookingId bookingId) {
    return new BookingCancelledEvent(bookingId, null, BookingEventType.BOOKING_CANCELLED);
  }
}

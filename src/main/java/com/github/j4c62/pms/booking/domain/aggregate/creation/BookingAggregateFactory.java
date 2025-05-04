package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;

public final class BookingAggregateFactory {
  private BookingAggregateFactory() {}

  public static BookingAggregate createBookingAggregate(
      BookingId bookingId,
      PropertyId propertyId,
      GuestId guestId,
      BookingDates bookingDates,
      BookingStatus status,
      BookingEvents bookingEvents) {
    return new BookingAggregate(
        bookingId, propertyId, guestId, bookingDates, status, bookingEvents);
  }
}

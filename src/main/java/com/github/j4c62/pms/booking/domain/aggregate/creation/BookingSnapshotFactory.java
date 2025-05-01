package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;

public final class BookingSnapshotFactory {

  private BookingSnapshotFactory() {}

  public static BookingSnapshot createBookingSnapshot(
      BookingId bookingId,
      PropertyId propertyId,
      GuestId guestId,
      BookingDates bookingDates,
      BookingStatus status) {
    return new BookingSnapshot(bookingId, propertyId, guestId, bookingDates, status);
  }
}

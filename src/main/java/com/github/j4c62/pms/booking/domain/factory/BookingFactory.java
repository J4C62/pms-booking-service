package com.github.j4c62.pms.booking.domain.factory;

import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;

public class BookingFactory {
  public static BookingFactory createBookingFactory() {
    return new BookingFactory();
  }

  public Booking create(
      String bookingId,
      String propertyId,
      String guestId,
      String startDate,
      String endDate,
      BookingStatus status) {

    return new Booking(
        requireNonNull(bookingId, "Booking ID cannot be null"),
        requireNonNull(propertyId, "Property ID cannot be null"),
        requireNonNull(guestId, "Guest ID cannot be null"),
        requireNonNull(startDate, "Start Date cannot be null"),
        requireNonNull(endDate, "End Date cannot be null"),
        status != null ? status : BookingStatus.PENDING);
  }
}

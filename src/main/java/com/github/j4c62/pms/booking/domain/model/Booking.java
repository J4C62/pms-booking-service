package com.github.j4c62.pms.booking.domain.model;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.*;

public record Booking(
    String bookingId,
    String propertyId,
    String guestId,
    String startDate,
    String endDate,
    BookingStatus status) {

  public Booking markAsPending() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, PENDING);
  }

  public Booking confirm() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, CONFIRMED);
  }

  public Booking cancel() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, CANCELLED);
  }

  public Booking updateDates(String newStartDate, String newEndDate) {
    return new Booking(bookingId, propertyId, guestId, newStartDate, newEndDate, status);
  }
}

package com.github.j4c62.pms.booking.domain.model;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.*;

import java.util.Objects;

public record Booking(
    String bookingId,
    String propertyId,
    String guestId,
    String startDate,
    String endDate,
    BookingStatus status) {

  public boolean isCancelled() {
    return status.equals(CANCELLED);
  }

  public boolean isPending() {
    return status.equals(PENDING);
  }

  public void validateCancellable() {
    if (!this.isPending()) {
      throw new IllegalStateException("Cannot cancel this booking");
    }
  }

  public void validateUpdatable(String newStart, String newEnd) {
    if (this.isCancelled()) {
      throw new IllegalStateException("Cannot update a cancelled booking");
    }
    if (Objects.equals(this.startDate, newStart)) {
      throw new IllegalStateException("No changes detected in booking start date");
    }
    if (Objects.equals(this.endDate, newEnd)) {
      throw new IllegalStateException("No changes detected in booking end date");
    }
  }

  public Booking markAsPending() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, PENDING);
  }

  public Booking cancel() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, CANCELLED);
  }

  public Booking updateDates(String newStartDate, String newEndDate) {
    return new Booking(bookingId, propertyId, guestId, newStartDate, newEndDate, status);
  }
}

package com.github.j4c62.pms.booking.application.creation.builder;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.time.LocalDate;
import java.util.UUID;

public final class BookingBuilder {
  private UUID bookingId;
  private UUID propertyId;
  private UUID guestId;
  private LocalDate startDate;
  private LocalDate endDate;
  private BookingStatus status = PENDING;

  private BookingBuilder() {}

  public static BookingBuilder builder() {
    return new BookingBuilder();
  }

  public BookingBuilder bookingId(UUID bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  public BookingBuilder propertyId(UUID propertyId) {
    this.propertyId = propertyId;
    return this;
  }

  public BookingBuilder guestId(UUID guestId) {
    this.guestId = guestId;
    return this;
  }

  public BookingBuilder startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  public BookingBuilder endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public BookingBuilder status(BookingStatus status) {
    this.status = status;
    return this;
  }

  public Booking build() {
    return new Booking(bookingId, propertyId, guestId, startDate, endDate, status);
  }
}

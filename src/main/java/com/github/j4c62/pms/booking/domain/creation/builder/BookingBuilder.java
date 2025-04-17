package com.github.j4c62.pms.booking.domain.creation.builder;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;

public final class BookingBuilder {
  private String bookingId;
  private String propertyId;
  private String guestId;
  private String startDate;
  private String endDate;
  private BookingStatus status = PENDING;

  private BookingBuilder() {}

  public static BookingBuilder builder() {
    return new BookingBuilder();
  }

  public BookingBuilder bookingId(String bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  public BookingBuilder propertyId(String propertyId) {
    this.propertyId = propertyId;
    return this;
  }

  public BookingBuilder guestId(String guestId) {
    this.guestId = guestId;
    return this;
  }

  public BookingBuilder startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  public BookingBuilder endDate(String endDate) {
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

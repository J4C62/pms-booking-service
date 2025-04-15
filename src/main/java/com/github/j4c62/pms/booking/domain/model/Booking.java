package com.github.j4c62.pms.booking.domain.model;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.*;
import static com.github.j4c62.pms.booking.domain.shared.SafeExecutor.tryOpt;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String bookingId;
    private String propertyId;
    private String guestId;
    private String startDate;
    private String endDate;
    private BookingStatus status = PENDING;

    public Builder bookingId(String bookingId) {
      this.bookingId = bookingId;
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder guestId(String guestId) {
      this.guestId = guestId;
      return this;
    }

    public Builder startDate(String startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public Builder status(BookingStatus status) {
      this.status = status;
      return this;
    }

    public Booking build() {
      requireNonNull(bookingId, "bookingId must not be null");
      requireNonNull(propertyId, "propertyId must not be null");
      requireNonNull(guestId, "guestId must not be null");
      requireNonNull(startDate, "startDate must not be null");
      requireNonNull(endDate, "endDate must not be null");
      var parsedStartDate =
          tryOpt(this::parseDate, startDate)
              .orElseThrow(() -> new IllegalArgumentException("Invalid start date"));
      var parsedEndDate =
          tryOpt(this::parseDate, endDate)
              .orElseThrow(() -> new IllegalArgumentException("Invalid end date"));

      return new Booking(
          bookingId,
          propertyId,
          guestId,
          String.valueOf(parsedStartDate),
          String.valueOf(parsedEndDate),
          status);
    }

    private LocalDate parseDate(String dateStr) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return LocalDate.parse(dateStr, formatter);
    }
  }
}

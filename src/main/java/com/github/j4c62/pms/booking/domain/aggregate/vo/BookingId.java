package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public record BookingId(UUID value) {
  public BookingId {
    requireNonNull(value, "Booking ID cannot be null");
  }

  public static BookingId of(UUID value) {
    return new BookingId(value);
  }
}

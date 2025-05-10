package com.github.j4c62.pms.booking.domain.aggregate.vo;

public enum BookingStatus {
  PENDING,
  CANCELLED,
  CONFIRMED;

  public boolean isCancelled() {
    return this == CANCELLED;
  }
}

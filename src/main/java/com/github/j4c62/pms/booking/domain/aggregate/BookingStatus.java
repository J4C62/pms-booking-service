package com.github.j4c62.pms.booking.domain.aggregate;

public enum BookingStatus {
  PENDING,
  CANCELLED;

  public boolean isCancelled() {
    return this == CANCELLED;
  }
}

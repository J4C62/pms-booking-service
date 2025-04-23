package com.github.j4c62.pms.booking.domain.model;

public enum BookingStatus {
  PENDING,
  CANCELLED;

  public boolean isCancelled() {
    return this == CANCELLED;
  }
}

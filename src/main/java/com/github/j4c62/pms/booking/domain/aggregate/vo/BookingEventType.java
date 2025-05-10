package com.github.j4c62.pms.booking.domain.aggregate.vo;

public enum BookingEventType {
  BOOKING_CREATED("booking.created"),
  BOOKING_UPDATED("booking.updated"),
  BOOKING_CONFIRMED("booking.confirmed"),
  BOOKING_CANCELLED("booking.cancelled");
  private final String eventType;

  BookingEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getEventType() {
    return eventType;
  }
}

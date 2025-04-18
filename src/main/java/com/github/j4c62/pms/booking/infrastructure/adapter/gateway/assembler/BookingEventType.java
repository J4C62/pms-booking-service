package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingEventType {
  BOOKING_CREATED("booking.created"),
  BOOKING_UPDATED("booking.updated"),
  BOOKING_CANCELLED("booking.cancelled");
  private final String eventType;
}

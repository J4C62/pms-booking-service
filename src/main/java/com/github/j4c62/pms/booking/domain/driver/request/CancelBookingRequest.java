package com.github.j4c62.pms.booking.domain.driver.request;

public interface CancelBookingRequest {
  String bookingId();

  String reason();

  String cancelledBy();

  String cancelledAt();
}

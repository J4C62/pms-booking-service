package com.github.j4c62.pms.booking.domain.driver.request;

public interface UpdateBookingRequest {
  String bookingId();

  String newStartDate();

  String newEndDate();

  String updateReason();
}

package com.github.j4c62.pms.booking.domain.driver.request;

public interface CreateBookingRequest {
  String propertyId();

  String guestId();

  String startDate();

  String endDate();
}

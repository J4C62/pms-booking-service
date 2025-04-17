package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.request.CreateBookingRequest;
import com.github.j4c62.pms.booking.domain.model.Booking;

public interface BookingCreator {
  Booking create(CreateBookingRequest bookingCreatedInput);
}

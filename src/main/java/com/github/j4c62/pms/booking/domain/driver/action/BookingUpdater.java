package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.request.UpdateBookingRequest;
import com.github.j4c62.pms.booking.domain.model.Booking;

public interface BookingUpdater {
  Booking update(UpdateBookingRequest updateBookingRequest);
}

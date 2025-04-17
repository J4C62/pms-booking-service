package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.request.CancelBookingRequest;
import com.github.j4c62.pms.booking.domain.model.Booking;

public interface BookingCanceller {
  Booking cancel(CancelBookingRequest cancelBookingRequest);
}

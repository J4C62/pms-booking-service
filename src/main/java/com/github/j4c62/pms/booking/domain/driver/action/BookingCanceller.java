package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingCanceller {
  BookingOutput cancel(CancelBookingInput cancelBookingInput);
}

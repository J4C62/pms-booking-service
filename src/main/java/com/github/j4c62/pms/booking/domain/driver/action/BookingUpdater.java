package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingUpdater {
  BookingOutput update(UpdateBookingInput updateBookingInput);
}

package com.github.j4c62.pms.booking.domain.driver.action;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingCreator {
  BookingOutput create(CreateBookingInput createBookingInput);
}

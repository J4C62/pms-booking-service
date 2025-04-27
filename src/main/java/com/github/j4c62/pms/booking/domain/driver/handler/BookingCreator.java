package com.github.j4c62.pms.booking.domain.driver.handler;

import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingCreator {
  BookingOutput create(CreateBookingCommand createBookingInput);
}

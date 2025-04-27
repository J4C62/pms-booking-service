package com.github.j4c62.pms.booking.domain.driver.handler;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingHandler {
  BookingOutput handle(Command command);
}

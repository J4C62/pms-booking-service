package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingCommandStrategy<T extends Command> {
  boolean supports(Command command);

  BookingOutput execute(T command);
}

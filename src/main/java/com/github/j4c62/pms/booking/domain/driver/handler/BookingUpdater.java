package com.github.j4c62.pms.booking.domain.driver.handler;

import com.github.j4c62.pms.booking.domain.driver.command.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingUpdater {
  BookingOutput update(UpdateBookingDatesCommand updateBookingInput);
}

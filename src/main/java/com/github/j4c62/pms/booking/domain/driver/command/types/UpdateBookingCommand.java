package com.github.j4c62.pms.booking.domain.driver.command.types;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;

public interface UpdateBookingCommand extends Command {
  BookingId bookingId();
}

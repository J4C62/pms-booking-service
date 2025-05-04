package com.github.j4c62.pms.booking.domain.driver.command;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public interface UpdateBookingCommand extends Command {
  BookingId bookingId();
}

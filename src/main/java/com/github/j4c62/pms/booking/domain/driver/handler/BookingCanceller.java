package com.github.j4c62.pms.booking.domain.driver.handler;

import com.github.j4c62.pms.booking.domain.driver.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

public interface BookingCanceller {
  BookingOutput cancel(CancelBookingCommand cancelBookingInput);
}

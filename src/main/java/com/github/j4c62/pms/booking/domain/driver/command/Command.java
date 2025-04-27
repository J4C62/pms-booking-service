package com.github.j4c62.pms.booking.domain.driver.command;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;

public interface Command {
  BookingAggregate applyTo(BookingAggregate aggregate);
}

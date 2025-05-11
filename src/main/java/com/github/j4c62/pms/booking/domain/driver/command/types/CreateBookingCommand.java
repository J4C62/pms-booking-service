package com.github.j4c62.pms.booking.domain.driver.command.types;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;

public record CreateBookingCommand(
    PropertyId propertyId, GuestId guestId, BookingDates bookingDates) implements Command {

  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return BookingEventFactory.createBookingEvent(aggregate).applyTo(null);
  }
}

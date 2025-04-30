package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;

import java.time.Instant;

public record CreateBookingCommand(
    PropertyId propertyId, GuestId guestId, BookingDates bookingDates) implements Command {

  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return new BookingCreatedEvent(
            aggregate.bookingId(),
            aggregate.propertyId(),
            aggregate.guestId(),
            aggregate.bookingDates(),
            Instant.now())
        .applyTo(null);
  }
}

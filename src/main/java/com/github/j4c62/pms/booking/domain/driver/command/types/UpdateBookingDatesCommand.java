package com.github.j4c62.pms.booking.domain.driver.command.types;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public record UpdateBookingDatesCommand(
    BookingId bookingId, BookingDates bookingDates, String updateReason)
    implements UpdateBookingCommand {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    var event = createBookingEvent(bookingId, bookingDates);
    return event.applyTo(aggregate);
  }
}

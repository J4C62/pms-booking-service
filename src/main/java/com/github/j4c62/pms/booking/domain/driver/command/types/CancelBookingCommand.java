package com.github.j4c62.pms.booking.domain.driver.command.types;


import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public record CancelBookingCommand(BookingId bookingId, String reason, String cancelledBy)
    implements UpdateBookingCommand {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    var event = BookingEventFactory.createCancelledBookingEvent(bookingId);
    return event.applyTo(aggregate);
  }
}

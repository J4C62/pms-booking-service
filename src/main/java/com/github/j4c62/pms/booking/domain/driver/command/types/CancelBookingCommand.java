package com.github.j4c62.pms.booking.domain.driver.command.types;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

public record CancelBookingCommand(BookingId bookingId, String reason, String cancelledBy)
    implements UpdateBookingCommand {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    var event =
        new BookingCancelledEvent(bookingId, Instant.now(), BookingEventType.BOOKING_CANCELLED);
    return event.applyTo(aggregate);
  }
}

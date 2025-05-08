package com.github.j4c62.pms.booking.domain.driver.command.types;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

public record UpdateBookingDatesCommand(
    BookingId bookingId, BookingDates bookingDates, String updateReason)
    implements UpdateBookingCommand {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    var event =
        new BookingUpdateEvent(
            bookingId, bookingDates, Instant.now(), BookingEventType.BOOKING_UPDATED);
    return event.applyTo(aggregate);
  }
}

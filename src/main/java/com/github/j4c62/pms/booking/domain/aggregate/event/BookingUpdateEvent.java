package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

public record BookingUpdateEvent(
    BookingId bookingId, BookingDates newDates, Instant occurredAt, BookingEventType eventType)
    implements BookingEvent {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.updateDates(newDates);
  }
}

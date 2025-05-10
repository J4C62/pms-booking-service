package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

public record BookingConfirmedEvent(
    BookingId bookingId, BookingEventType eventType, Instant occurredAt) implements BookingEvent {

  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.confirm();
  }
}

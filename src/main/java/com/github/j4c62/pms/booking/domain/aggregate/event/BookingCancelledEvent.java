package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType;
import java.time.Instant;

public record BookingCancelledEvent(BookingId bookingId, Instant occurredAt)
    implements BookingEvent {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.cancel();
  }

  @Override
  public BookingEventType eventType() {
    return BookingEventType.BOOKING_CANCELLED;
  }
}

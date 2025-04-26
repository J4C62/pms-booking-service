package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType;
import java.time.Instant;

public record BookingUpdateEvent(BookingId bookingId, BookingDates newDates, Instant occurredAt)
    implements BookingEvent {
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.updateDates(newDates);
  }

  @Override
  public BookingEventType eventType() {
    return BookingEventType.BOOKING_UPDATED;
  }
}

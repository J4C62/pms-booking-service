package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

public sealed interface BookingEvent
    permits BookingCancelledEvent, BookingCreatedEvent, BookingUpdateEvent, BookingConfirmedEvent {
  BookingId bookingId();

  BookingAggregate applyTo(BookingAggregate aggregate);

  BookingEventType eventType();

  Instant occurredAt();
}

package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType;

import java.time.Instant;

public sealed interface BookingEvent
    permits BookingCreatedEvent, BookingUpdateEvent, BookingCancelledEvent {
  BookingAggregate applyTo(BookingAggregate aggregate);

  BookingEventType eventType();

  Instant occurredAt();
}

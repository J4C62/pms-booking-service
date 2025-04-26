package com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.util.List;

public class SnapshotPolicy {

  private static final int MAX_EVENTS_BEFORE_SNAPSHOT = 10;

  public boolean shouldCreateSnapshot(BookingAggregate aggregate) {
    int numberOfEvents = aggregate.bookingEvents().events().size();

    if (numberOfEvents >= MAX_EVENTS_BEFORE_SNAPSHOT) {
      return true;
    }

    return isCriticalEvent(lastEvent(aggregate));
  }

  private BookingEvent lastEvent(BookingAggregate aggregate) {
    List<BookingEvent> events = aggregate.bookingEvents().events();
    return events.isEmpty() ? null : events.getLast();
  }

  private boolean isCriticalEvent(BookingEvent event) {
    if (event == null) return false;

    return switch (event) {
      case BookingCreatedEvent ignored -> true;
      case BookingCancelledEvent ignored -> true;
      default -> false;
    };
  }
}

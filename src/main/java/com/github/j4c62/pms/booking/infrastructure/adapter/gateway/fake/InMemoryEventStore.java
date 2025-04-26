package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import java.util.*;

public class InMemoryEventStore implements EventStore {

  private final Map<BookingId, List<BookingEvent>> store = new HashMap<>();

  @Override
  public void appendEvents(BookingId bookingId, List<BookingEvent> events) {
    store.computeIfAbsent(bookingId, id -> new ArrayList<>()).addAll(events);
  }

  @Override
  public List<BookingEvent> getEventsForBooking(BookingId bookingId) {
    return store.getOrDefault(bookingId, Collections.emptyList());
  }
}

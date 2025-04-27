package com.github.j4c62.pms.booking.shared.fake;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class InMemoryEventStore implements EventStore {

  private static final Map<BookingId, BookingEvents> EVENTS_MAP = new HashMap<>();
  private static final Map<BookingId, BookingEvents> PREVIOUS_EVENTS_MAP = new HashMap<>();

  private static final UUID PREDEFINED_BOOKING_ID =
      UUID.nameUUIDFromBytes("booking-123".getBytes());

  private static final UUID PREDEFINED_PROPERTY_ID =
      UUID.nameUUIDFromBytes("property-456".getBytes());
  private static final UUID PREDEFINED_GUEST_ID = UUID.nameUUIDFromBytes("guest-789".getBytes());

  static {
    final var bookingId = new BookingId(PREDEFINED_BOOKING_ID);
    final var propertyId = new PropertyId(PREDEFINED_PROPERTY_ID);
    final var guestId = new GuestId(PREDEFINED_GUEST_ID);

    var event =
        new BookingCreatedEvent(
            bookingId,
            propertyId,
            guestId,
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            Instant.now());

    var events = new BookingEvents(List.of(event));
    EVENTS_MAP.put(bookingId, events);
  }

  @Override
  public void appendEvents(BookingId bookingId, BookingEvents events) {
    PREVIOUS_EVENTS_MAP.put(
        bookingId, EVENTS_MAP.getOrDefault(bookingId, new BookingEvents(List.of())));

    EVENTS_MAP.compute(
        bookingId,
        (id, existingEvents) -> {
          if (existingEvents == null) {
            return new BookingEvents(List.copyOf(events.events()));
          } else {
            return new BookingEvents(
                Stream.concat(existingEvents.events().stream(), events.events().stream()).toList());
          }
        });
  }

  @Override
  public BookingEvents getEventsForBooking(BookingId bookingId) {
    return EVENTS_MAP.getOrDefault(bookingId, new BookingEvents(List.of()));
  }

  public void restoreState() {
    var previousEvents = PREVIOUS_EVENTS_MAP.get(new BookingId(PREDEFINED_BOOKING_ID));
    if (previousEvents != null) {
      EVENTS_MAP.put(new BookingId(PREDEFINED_BOOKING_ID), previousEvents);
    }
  }
}

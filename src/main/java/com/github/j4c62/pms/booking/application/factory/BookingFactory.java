package com.github.j4c62.pms.booking.application.factory;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import java.time.Instant;
import java.util.List;

public final class BookingFactory {

  private BookingFactory() {}

  public static BookingAggregate createNew(BookingAggregate bookingAggregate) {
    return new BookingCreatedEvent(
            bookingAggregate.bookingId(),
            bookingAggregate.propertyId(),
            bookingAggregate.guestId(),
            bookingAggregate.bookingDates(),
            Instant.now())
        .applyTo(null);
  }

  public static BookingAggregate restoreFromSnapshotAndEvents(
      BookingSnapshot snapshot, List<BookingEvent> newEvents) {

    var base =
        new BookingAggregate(
            snapshot.bookingId(),
            snapshot.propertyId(),
            snapshot.guestId(),
            snapshot.bookingDates(),
            snapshot.status(),
            new BookingEvents(List.of()));

    return new BookingEvents(newEvents).replayOn(base);
  }

  public static BookingAggregate replay(List<BookingEvent> events) {
    if (events == null || events.isEmpty())
      throw new IllegalArgumentException("Event stream is empty");
    return new BookingEvents(events).replayOn(null);
  }
}

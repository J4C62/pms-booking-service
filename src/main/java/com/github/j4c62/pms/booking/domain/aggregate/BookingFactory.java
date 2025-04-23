package com.github.j4c62.pms.booking.domain.aggregate;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.util.List;

public final class BookingFactory {

  private BookingFactory() {}

  public static BookingAggregate createNew(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new BookingCreatedEvent(bookingId, propertyId, guestId, bookingDates).applyTo(null);
  }

  public static BookingAggregate restoreFromSnapshotAndEvents(
      BookingSnapshot snapshot, List<BookingEvent> newEvents) {

    BookingAggregate base =
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

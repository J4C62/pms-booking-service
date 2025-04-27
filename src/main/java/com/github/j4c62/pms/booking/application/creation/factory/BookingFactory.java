package com.github.j4c62.pms.booking.application.creation.factory;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import java.util.List;

public final class BookingFactory {

  private BookingFactory() {}

  public static BookingAggregate restoreFromSnapshotAndEvents(
      BookingSnapshot snapshot, BookingEvents newEvents) {

    var base =
        new BookingAggregate(
            snapshot.bookingId(),
            snapshot.propertyId(),
            snapshot.guestId(),
            snapshot.bookingDates(),
            snapshot.status(),
            new BookingEvents(List.of()));

    return newEvents.replayOn(base);
  }

  public static BookingAggregate replay(BookingEvents events) {
    if (events == null || events.events().isEmpty())
      throw new IllegalArgumentException("Event stream is empty");

    return events.replayOn(null);
  }
}

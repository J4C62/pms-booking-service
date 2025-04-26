package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookingCommandHandler implements BookingUpdater {

  private final EventStore eventStore;
  private final SnapshotStore snapshotStore;

  private static BookingUpdateEvent getBookingUpdateEvent(UpdateBookingInput input) {
    return new BookingUpdateEvent(input.bookingId(), input.bookingDates(), Instant.now());
  }

  @Override
  public BookingOutput update(UpdateBookingInput input) {
    var events = eventStore.getEventsForBooking(input.bookingId());

    var aggregate = getBookingAggregate(input, events);

    var updateEvent = getBookingUpdateEvent(input);
    var updated = updateEvent.applyTo(aggregate);

    eventStore.appendEvents(input.bookingId(), List.of(updateEvent));

    maybeSaveSnapshot(updated);

    return new BookingOutput(updated.bookingId().value(), updated.status());
  }

  private BookingAggregate getBookingAggregate(
      UpdateBookingInput input, List<BookingEvent> events) {
    return snapshotStore
        .getLatestSnapshot(input.bookingId())
        .map(snapshot -> BookingFactory.restoreFromSnapshotAndEvents(snapshot, events))
        .orElseGet(() -> BookingFactory.replay(events));
  }

  private void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (new SnapshotPolicy().shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

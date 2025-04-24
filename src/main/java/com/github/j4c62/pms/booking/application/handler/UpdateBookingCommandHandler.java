package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.BookingFactory;
import com.github.j4c62.pms.booking.domain.aggregate.EventStore;
import com.github.j4c62.pms.booking.domain.aggregate.SnapshotStore;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookingCommandHandler
    implements BookingUpdater {

  private final EventStore eventStore;
  private final SnapshotStore snapshotStore;


  @Override
  public BookingOutput update(UpdateBookingInput input) {
    var events = eventStore.getEventsForBooking(input.getBookingId());

    BookingAggregate aggregate = snapshotStore.getLatestSnapshot(input.getBookingId())
        .map(snapshot -> BookingFactory.restoreFromSnapshotAndEvents(snapshot, events))
        .orElseGet(() -> BookingFactory.replay(events));

    BookingUpdateEvent updateEvent =
        new BookingUpdateEvent(
            input.getBookingId(),
            input.getBookingDates(),
            Instant.now());
    BookingAggregate updated = updateEvent.applyTo(aggregate);

    eventStore.appendEvents(input.getBookingId(), List.of(updateEvent));

    maybeSaveSnapshot(updated);



    return new BookingOutput(updated.bookingId().value(), updated.status());
  }

  private void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (new SnapshotPolicy().shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

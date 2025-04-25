package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.BookingFactory;
import com.github.j4c62.pms.booking.domain.aggregate.EventStore;
import com.github.j4c62.pms.booking.domain.aggregate.SnapshotStore;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelBookingCommandHandler implements BookingCanceller {

  private final EventStore eventStore;
  private final SnapshotStore snapshotStore;

  @Override
  public BookingOutput cancel(CancelBookingInput input) {
    var events = eventStore.getEventsForBooking(input.getBookingId());
    var aggregate =
        snapshotStore
            .getLatestSnapshot(input.getBookingId())
            .map(snapshot -> BookingFactory.restoreFromSnapshotAndEvents(snapshot, events))
            .orElseGet(() -> BookingFactory.replay(events));

    var cancelEvent = new BookingCancelledEvent(input.getBookingId(), Instant.now());
    var updated = cancelEvent.applyTo(aggregate);

    eventStore.appendEvents(input.getBookingId(), List.of(cancelEvent));

    maybeSaveSnapshot(updated);

    return new BookingOutput(updated.bookingId().value(), updated.status());
  }

  private void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (new SnapshotPolicy().shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

package com.github.j4c62.pms.booking.application.facade;

import com.github.j4c62.pms.booking.application.creation.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.driver.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SnapshotFacade {
  private final SnapshotStore snapshotStore;
  private final SnapshotPolicy snapshotPolicy;

  public BookingAggregate restoreBookingAggregate(
      UpdateBookingCommand specificInput, BookingEvents events) {
    return snapshotStore
        .getLatestSnapshot(specificInput.bookingId())
        .map(snapshot -> BookingFactory.restoreFromSnapshotAndEvents(snapshot, events))
        .orElseGet(() -> BookingFactory.replay(events));
  }

  public void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (snapshotPolicy.shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

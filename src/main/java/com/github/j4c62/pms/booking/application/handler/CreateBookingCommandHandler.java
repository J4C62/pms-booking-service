package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.BookingFactory;
import com.github.j4c62.pms.booking.domain.aggregate.EventStore;
import com.github.j4c62.pms.booking.domain.aggregate.SnapshotStore;
import com.github.j4c62.pms.booking.domain.aggregate.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingCommandHandler implements BookingCreator {
  private final EventStore eventStore;
  private final SnapshotStore snapshotStore;
  private final SnapshotPolicy snapshotPolicy;

  @Transactional
  @Override
  public BookingOutput create(CreateBookingInput input) {
    BookingAggregate aggregate =
        BookingFactory.createNew(
            null, input.getPropertyId(), input.getGuestId(), input.getBookingDates());

    eventStore.appendEvents(aggregate.bookingId(), aggregate.bookingEvents().events());

    maybeSaveSnapshot(aggregate);

    return new BookingOutput(aggregate.bookingId().value(), aggregate.status());
  }

  private void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (snapshotPolicy.shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

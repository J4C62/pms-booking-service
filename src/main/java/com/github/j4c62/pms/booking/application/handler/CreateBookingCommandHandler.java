package com.github.j4c62.pms.booking.application.handler;

import static com.github.j4c62.pms.booking.domain.aggregate.BookingFactory.createNew;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
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
  private final BookingAggregateMapper bookingAggregateMapper;

  @Transactional
  @Override
  public BookingOutput create(CreateBookingInput input) {
    var aggregate = createNew(bookingAggregateMapper.toAggregate(input));
    eventStore.appendEvents(aggregate.bookingId(), aggregate.bookingEvents().events());
    maybeSaveSnapshot(aggregate);
    return new BookingOutput(aggregate.bookingId().value(), aggregate.status());
  }

  private void maybeSaveSnapshot(BookingAggregate aggregate) {
    if (new SnapshotPolicy().shouldCreateSnapshot(aggregate)) {
      snapshotStore.saveSnapshot(aggregate.toSnapshot());
    }
  }
}

package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.shared.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.shared.fake.InMemoryEventStore;
import com.github.j4c62.pms.booking.shared.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapperImpl;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.time.LocalDate;
import java.util.UUID;

public class GivenAUserWantsToMakeABooking extends Stage<GivenAUserWantsToMakeABooking> {

  @ProvidedScenarioState CreateBookingCommand createBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ProvidedScenarioState InMemorySnapshotStore snapshotStore = new InMemorySnapshotStore();

  @ProvidedScenarioState
  FakeBookingEventPublisher fakeBookingEventPublisher = new FakeBookingEventPublisher();

  @ProvidedScenarioState InMemoryEventStoreDecorator eventStore;

  @ProvidedScenarioState
  BookingAggregateMapper bookingCreateMapper = new BookingAggregateMapperImpl();

  @ProvidedScenarioState SnapshotPolicy snapshotPolicy = new SnapshotPolicy();

  public GivenAUserWantsToMakeABooking the_user_provides_valid_booking_details() {
    eventStore =
        new InMemoryEventStoreDecorator(new InMemoryEventStore(), fakeBookingEventPublisher);
    createBookingInput =
        new CreateBookingCommand(
            new PropertyId(UUID.randomUUID()),
            new GuestId(UUID.randomUUID()),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)));

    return self();
  }
}

package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapperImpl;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemoryEventStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.time.LocalDate;
import java.util.UUID;

public class GivenAUserWantsToMakeABooking extends Stage<GivenAUserWantsToMakeABooking> {

  @ProvidedScenarioState CreateBookingInput createBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ProvidedScenarioState InMemorySnapshotStore snapshotStore = new InMemorySnapshotStore();

  @ProvidedScenarioState
  FakeBookingEventPublisher fakeBookingEventPublisher = new FakeBookingEventPublisher();

  @ProvidedScenarioState InMemoryEventStoreDecorator eventStore;

  @ProvidedScenarioState
  BookingAggregateMapper bookingCreateMapper = new BookingAggregateMapperImpl();

  public GivenAUserWantsToMakeABooking the_user_provides_valid_booking_details() {
    eventStore =
        new InMemoryEventStoreDecorator(new InMemoryEventStore(), fakeBookingEventPublisher);
    createBookingInput =
        new CreateBookingInput(
            new PropertyId(UUID.randomUUID()),
            new GuestId(UUID.randomUUID()),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)));

    return self();
  }
}

package com.github.j4c62.pms.booking.acceptance.update.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapperImpl;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemoryEventStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class GivenAUserWantsToModifyBookingDates
    extends Stage<GivenAUserWantsToModifyBookingDates> {

  @ProvidedScenarioState UpdateBookingInput updateBookingInput;
  @ProvidedScenarioState BookingOutput bookingOutput;

  @ProvidedScenarioState InMemoryEventStoreDecorator eventStore;
  @ProvidedScenarioState InMemorySnapshotStore snapshotStore = new InMemorySnapshotStore();

  @ProvidedScenarioState
  FakeBookingEventPublisher fakeBookingEventPublisher = new FakeBookingEventPublisher();

  @ProvidedScenarioState
  BookingAggregateMapper bookingCreateMapper = new BookingAggregateMapperImpl();

  @ProvidedScenarioState UUID bookingId = UUID.randomUUID();

  public GivenAUserWantsToModifyBookingDates
      the_user_provides_valid_new_booking_dates_and_booking_exits() {
    eventStore =
        new InMemoryEventStoreDecorator(new InMemoryEventStore(), fakeBookingEventPublisher);

    eventStore.appendEvents(
        new BookingId(bookingId),
        List.of(
            new BookingCreatedEvent(
                new BookingId(bookingId),
                new PropertyId(UUID.randomUUID()),
                new GuestId(UUID.randomUUID()),
                new BookingDates(LocalDate.now(), LocalDate.now().plusDays(9)),
                Instant.now())));

    updateBookingInput =
        new UpdateBookingInput(
            new BookingId(bookingId),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            "We need to stay more",
            String.valueOf(Instant.now()));
    return self();
  }
}

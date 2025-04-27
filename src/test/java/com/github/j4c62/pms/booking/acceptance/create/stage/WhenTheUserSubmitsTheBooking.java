package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.facade.BookingFacade;
import com.github.j4c62.pms.booking.application.facade.SnapshotFacade;
import com.github.j4c62.pms.booking.application.handler.BookingCommandHandler;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenTheUserSubmitsTheBooking extends Stage<WhenTheUserSubmitsTheBooking> {

  @ExpectedScenarioState CreateBookingCommand createBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;

  @ExpectedScenarioState InMemorySnapshotStore snapshotStore;

  @ExpectedScenarioState BookingAggregateMapper bookingCreateMapper;

  @ExpectedScenarioState SnapshotPolicy snapshotPolicy;

  public WhenTheUserSubmitsTheBooking the_booking_is_created() {
    var handler =
        new BookingCommandHandler(
            new BookingFacade(
                eventStore,
                new SnapshotFacade(snapshotStore, snapshotPolicy),
                bookingCreateMapper));

    bookingOutput = handler.handle(createBookingInput);
    return self();
  }
}

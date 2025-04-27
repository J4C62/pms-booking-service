package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapperImpl;
import com.github.j4c62.pms.booking.application.facade.BookingFacade;
import com.github.j4c62.pms.booking.application.facade.SnapshotFacade;
import com.github.j4c62.pms.booking.application.handler.BookingCommandHandler;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import com.github.j4c62.pms.booking.domain.driver.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenTheUserCancelsTheBooking extends Stage<WhenTheUserCancelsTheBooking> {

  @ExpectedScenarioState CancelBookingCommand cancelBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;
  @ExpectedScenarioState InMemorySnapshotStore snapshotStore;
  @ExpectedScenarioState SnapshotPolicy snapshotPolicy;

  public WhenTheUserCancelsTheBooking the_booking_is_cancelled() {
    var handler =
        new BookingCommandHandler(
            new BookingFacade(
                eventStore,
                new SnapshotFacade(snapshotStore, snapshotPolicy),
                new BookingAggregateMapperImpl()));

    bookingOutput = handler.handle(cancelBookingInput);
    return self();
  }
}

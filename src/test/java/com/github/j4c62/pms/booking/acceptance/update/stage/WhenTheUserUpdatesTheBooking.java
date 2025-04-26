package com.github.j4c62.pms.booking.acceptance.update.stage;

import com.github.j4c62.pms.booking.application.handler.UpdateBookingCommandHandler;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenTheUserUpdatesTheBooking extends Stage<WhenTheUserUpdatesTheBooking> {
  @ExpectedScenarioState UpdateBookingInput updateBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;
  @ExpectedScenarioState InMemorySnapshotStore snapshotStore;

  public WhenTheUserUpdatesTheBooking the_booking_is_updated() {

    var handler = new UpdateBookingCommandHandler(eventStore, snapshotStore);
    bookingOutput = handler.update(updateBookingInput);

    return self();
  }
}

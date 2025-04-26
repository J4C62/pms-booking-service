package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.handler.CancelBookingCommandHandler;
import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenTheUserCancelsTheBooking extends Stage<WhenTheUserCancelsTheBooking> {

  @ExpectedScenarioState CancelBookingInput cancelBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;
  @ExpectedScenarioState InMemorySnapshotStore snapshotStore;

  public WhenTheUserCancelsTheBooking the_booking_is_cancelled() {
    var handler = new CancelBookingCommandHandler(eventStore, snapshotStore);

    bookingOutput = handler.cancel(cancelBookingInput);
    return self();
  }
}

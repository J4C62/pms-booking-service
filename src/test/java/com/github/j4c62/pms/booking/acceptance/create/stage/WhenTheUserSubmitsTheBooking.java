package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.handler.CreateBookingCommandHandler;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenTheUserSubmitsTheBooking extends Stage<WhenTheUserSubmitsTheBooking> {

  @ExpectedScenarioState CreateBookingInput createBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;

  @ExpectedScenarioState InMemorySnapshotStore snapshotStore;

  @ExpectedScenarioState BookingAggregateMapper bookingCreateMapper;

  public WhenTheUserSubmitsTheBooking the_booking_is_created() {
    var handler = new CreateBookingCommandHandler(eventStore, snapshotStore, bookingCreateMapper);

    bookingOutput = handler.create(createBookingInput);
    return self();
  }
}

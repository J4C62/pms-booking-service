package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class GivenAUserWantsToMakeABooking {
  @ExpectedScenarioState Fixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  public GivenAUserWantsToMakeABooking the_user_provides_valid_booking_details() {
    bookingCommand = setUpFixture.createBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
    return this;
  }
}

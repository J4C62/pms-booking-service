package com.github.j4c62.pms.booking.application.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class GivenAUserWantsToCancelABooking {

  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  public GivenAUserWantsToCancelABooking the_user_provides_a_valid_booking_id() {
    bookingCommand = setUpFixture.cancelBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
    return this;
  }
}

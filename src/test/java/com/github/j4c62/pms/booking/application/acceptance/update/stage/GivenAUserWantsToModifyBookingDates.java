package com.github.j4c62.pms.booking.application.acceptance.update.stage;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class GivenAUserWantsToModifyBookingDates {

  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  public GivenAUserWantsToModifyBookingDates
      the_user_provides_valid_new_booking_dates_and_booking_exits() {
    bookingCommand = setUpFixture.updateBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
    return this;
  }
}

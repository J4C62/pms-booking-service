package com.github.j4c62.pms.booking.application.acceptance.update.stage;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'Given' stage that sets up the scenario where a user wants to modify the booking dates of
 * an existing booking.
 *
 * <p>This stage prepares the necessary state and dependencies to simulate a valid request to update
 * booking dates. It assumes that the booking already exists and the new dates are valid.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class GivenUserWantsToModifyBookingDates {

  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  /**
   * Sets up the scenario where the user provides valid new booking dates and the booking already
   * exists in the system.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theUserProvidesValidNewBookingDatesAndBookingExits() {
    bookingCommand = setUpFixture.updateBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
  }
}

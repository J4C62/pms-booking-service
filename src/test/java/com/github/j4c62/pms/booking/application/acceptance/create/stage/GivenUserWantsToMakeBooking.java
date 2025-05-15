package com.github.j4c62.pms.booking.application.acceptance.create.stage;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'Given' stage that sets up a scenario where the user wants to make a booking.
 *
 * <p>This stage provides a valid {@link Command} to create a booking, and prepares the {@link
 * BookingHandler} that will handle it.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class GivenUserWantsToMakeBooking {
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  /**
   * Sets up the state where the user has provided valid booking details.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theUserProvidesValidBookingDetails() {
    bookingCommand = setUpFixture.createBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
  }
}

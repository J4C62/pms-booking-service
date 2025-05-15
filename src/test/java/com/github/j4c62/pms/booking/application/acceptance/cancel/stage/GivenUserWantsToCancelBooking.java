package com.github.j4c62.pms.booking.application.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'Given' stage that prepares the context for a user attempting to cancel a booking.
 *
 * <p>This stage sets up a valid {@link Command} representing the cancellation request, and provides
 * a {@link BookingHandler} capable of handling that command.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class GivenUserWantsToCancelBooking {

  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState Command bookingCommand;
  @ProvidedScenarioState BookingHandler bookingCommandHandler;

  /**
   * Initializes the cancellation command and booking handler using the shared test fixture.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theUserProvidesValidBookingId() {
    bookingCommand = setUpFixture.cancelBookingCommand();
    bookingCommandHandler = setUpFixture.bookingCommandHandler();
  }
}

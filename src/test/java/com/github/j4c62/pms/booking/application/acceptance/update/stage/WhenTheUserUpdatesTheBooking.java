package com.github.j4c62.pms.booking.application.acceptance.update.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.when;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'When' stage that handles the action of updating a booking.
 *
 * <p>This stage executes the update command using the {@link BookingHandler} and stores the
 * resulting {@link BookingOutput} as scenario state for use in subsequent test stages.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class WhenTheUserUpdatesTheBooking {
  @ExpectedScenarioState Command bookingCommand;
  @ExpectedScenarioState BookingHandler bookingCommandHandler;
  @ProvidedScenarioState BookingOutput bookingOutput;

  /**
   * Executes the booking update command and saves the result for later verification.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theBookingIsUpdated() {
    bookingOutput = when(bookingCommandHandler, bookingCommand);
  }
}

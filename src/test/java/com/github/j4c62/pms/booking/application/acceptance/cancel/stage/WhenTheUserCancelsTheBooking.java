package com.github.j4c62.pms.booking.application.acceptance.cancel.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.when;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'When' stage that handles the user action of cancelling a booking.
 *
 * <p>This stage simulates the execution of a cancel booking {@link Command} using the {@link
 * BookingHandler} and stores the resulting {@link BookingOutput} for further verification.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class WhenTheUserCancelsTheBooking {
  @ExpectedScenarioState Command bookingCommand;
  @ExpectedScenarioState BookingHandler bookingCommandHandler;
  @ProvidedScenarioState BookingOutput bookingOutput;

  /**
   * Executes the cancellation of the booking using the command and stores the result.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theBookingIsCancelled() {
    bookingOutput = when(bookingCommandHandler, bookingCommand);
  }
}

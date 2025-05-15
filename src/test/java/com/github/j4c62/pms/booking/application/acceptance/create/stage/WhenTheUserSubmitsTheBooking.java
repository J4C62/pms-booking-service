package com.github.j4c62.pms.booking.application.acceptance.create.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.when;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * JGiven 'When' stage that simulates the user submitting a booking request.
 *
 * <p>This stage represents the action of creating a booking using the provided command and booking
 * handler. The resulting {@link BookingOutput} is stored and made available for subsequent stages.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class WhenTheUserSubmitsTheBooking {

  @ExpectedScenarioState Command bookingCommand;
  @ExpectedScenarioState BookingHandler bookingCommandHandler;
  @ProvidedScenarioState BookingOutput bookingOutput;

  /**
   * Executes the booking command using the booking handler, simulating the user submitting a
   * booking request.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theBookingIsCreated() {

    bookingOutput = when(bookingCommandHandler, bookingCommand);
  }
}

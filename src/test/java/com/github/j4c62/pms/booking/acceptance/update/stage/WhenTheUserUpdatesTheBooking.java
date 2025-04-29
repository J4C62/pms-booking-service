package com.github.j4c62.pms.booking.acceptance.update.stage;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenTheUserUpdatesTheBooking {
  @ExpectedScenarioState Command bookingCommand;
  @ExpectedScenarioState BookingHandler bookingCommandHandler;
  @ProvidedScenarioState BookingOutput bookingOutput;

  public WhenTheUserUpdatesTheBooking the_booking_is_updated() {

    bookingOutput = bookingCommandHandler.handle(bookingCommand);

    return this;
  }
}

package com.github.j4c62.pms.booking.application.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.BookingTestUtils;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenTheUserCancelsTheBooking {
  @ExpectedScenarioState Command bookingCommand;
  @ExpectedScenarioState BookingHandler bookingCommandHandler;
  @ProvidedScenarioState BookingOutput bookingOutput;

  public WhenTheUserCancelsTheBooking the_booking_is_cancelled() {
    bookingOutput = BookingTestUtils.when(bookingCommandHandler, bookingCommand);
    return this;
  }
}

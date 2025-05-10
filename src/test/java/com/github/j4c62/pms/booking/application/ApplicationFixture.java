package com.github.j4c62.pms.booking.application;

import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.shared.DrivenFixture;
import com.github.j4c62.pms.booking.shared.DriverFixture;
import com.tngtech.jgiven.integration.spring.EnableJGiven;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@TestConfiguration
@ComponentScan("com.github.j4c62.pms.booking.application")
@Import({DrivenFixture.class, DriverFixture.class})
@EnableJGiven
public class ApplicationFixture {

  @TestComponent
  public record SetUpFixture(
      BookingEventPublisher bookingEventPublisher,
      BookingHandler bookingCommandHandler,
      @Qualifier("createBookingCommand") Command createBookingCommand,
      @Qualifier("updateBookingDatesCommand") Command updateBookingCommand,
      @Qualifier("cancelBookingCommand") Command cancelBookingCommand) {}
}

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

/**
 * Test configuration that wires the application layer and its dependencies for integration or slice
 * testing.
 *
 * <p>This configuration loads the booking application components, mocks from the driven and driver
 * sides, and enables {@code JGiven} for BDD-style testing.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
@TestConfiguration
@ComponentScan("com.github.j4c62.pms.booking.application")
@Import({DrivenFixture.class, DriverFixture.class})
@EnableJGiven
public class ApplicationFixture {

  /**
   * Record that aggregates commonly required test beans for setup and verification in
   * application-level tests.
   *
   * @param bookingEventPublisher the mock publisher used to capture emitted domain events
   * @param bookingCommandHandler the application service or use case handler
   * @param createBookingCommand a predefined create booking command for test execution
   * @param updateBookingCommand a predefined update booking command for test execution
   * @param cancelBookingCommand a predefined cancel booking command for test execution
   * @author Jose Antonio (J4c62)
   * @version 1.0.0
   * @since 2025-05-10
   */
  @TestComponent
  public record SetUpFixture(
      BookingEventPublisher bookingEventPublisher,
      BookingHandler bookingCommandHandler,
      @Qualifier("createBookingCommand") Command createBookingCommand,
      @Qualifier("updateBookingDatesCommand") Command updateBookingCommand,
      @Qualifier("cancelBookingCommand") Command cancelBookingCommand) {}
}

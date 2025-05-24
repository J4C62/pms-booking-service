package com.github.j4c62.pms.booking.shared;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.types.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Test configuration class that defines sample command beans and a fallback {@link BookingHandler}
 * for integration testing purposes.
 *
 * <p>This fixture is used in tests to inject mocked or sample {@link Command} instances and a basic
 * implementation of {@link BookingHandler}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
@TestConfiguration
@Import(AggregateFixture.class)
public class DriverFixture {
  /**
   * Creates a sample {@link CreateBookingCommand} with injected {@link PropertyId}, {@link
   * GuestId}, and {@link BookingDates}.
   *
   * @param propertyId the property identifier
   * @param guestId the guest identifier
   * @param bookingDates the booking date range
   * @return a new {@link CreateBookingCommand} instance
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("createBookingCommand")
  public Command createBookingCommand(
      PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new CreateBookingCommand(propertyId, guestId, bookingDates);
  }

  /**
   * Creates a sample {@link UpdateBookingDatesCommand} with fixed reason and dates.
   *
   * @param bookingId the booking identifier
   * @return a new {@link UpdateBookingDatesCommand} instance
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("updateBookingDatesCommand")
  public Command updateBookingCommand(BookingId bookingId, GuestId guestId) {
    var updateReason = "We have to stay seven day more";
    var dates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(7));
    return new UpdateBookingDatesCommand(bookingId, guestId, dates, updateReason);
  }

  /**
   * Creates a sample {@link CancelBookingCommand} with fixed reason and cancellation initiator.
   *
   * @param bookingId the booking identifier
   * @return a new {@link CancelBookingCommand} instance
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("cancelBookingCommand")
  public Command cancelBookingCommand(BookingId bookingId, GuestId guestId) {
    var cancelReason = "Emergency";
    return new CancelBookingCommand(bookingId, guestId, cancelReason);
  }

  /**
   * Provides a fallback {@link BookingHandler} that returns basic {@link BookingOutput} results
   * based on the type of {@link Command} received.
   *
   * <p>This bean is only created if no other {@link BookingHandler} is present in the context.
   *
   * @return a default {@link BookingHandler} implementation
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @ConditionalOnMissingBean(BookingHandler.class)
  public BookingHandler bookingCreator() {
    return req -> switch (req) {
      case UpdateBookingDatesCommand cmd ->
          new BookingOutput(cmd.bookingId(), PENDING);
      case CancelBookingCommand cmd ->
          new BookingOutput(cmd.bookingId(), CANCELLED);
      default ->
          new BookingOutput(BookingId.of(UUID.randomUUID()), PENDING);
    };
  }
}

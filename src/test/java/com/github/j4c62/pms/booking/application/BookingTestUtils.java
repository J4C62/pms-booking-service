package com.github.j4c62.pms.booking.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import org.mockito.ArgumentCaptor;

/**
 * Utility class containing helper methods for testing booking operations and event publishing.
 *
 * <p>This class provides static methods to invoke handlers, assert booking output, and verify that
 * events are published correctly.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
public class BookingTestUtils {

  /**
   * Executes a booking command through the provided handler.
   *
   * @param bookingCommandHandler the command handler to execute the command with
   * @param command the command to execute
   * @return the resulting {@link BookingOutput} after handling the command
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingOutput when(BookingHandler bookingCommandHandler, Command command) {
    return bookingCommandHandler.handle(command);
  }

  /**
   * Verifies that a booking event was published the expected number of times, and asserts that the
   * event type and booking ID match the expected output.
   *
   * @param bookingEventPublisher the mocked event publisher
   * @param times the expected number of times the event should have been published
   * @param argumentCaptor the captor used to capture the published event
   * @param bookingEventType the expected event type
   * @param bookingOutput the booking output whose ID should match the event
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static void thenTheEventIsPublished(
      BookingEventPublisher bookingEventPublisher,
      int times,
      ArgumentCaptor<BookingEvent> argumentCaptor,
      BookingEventType bookingEventType,
      BookingOutput bookingOutput) {
    verify(bookingEventPublisher, times(times)).publish(argumentCaptor.capture());
    var bookingCreatedEvent = argumentCaptor.getValue();
    assertThat(bookingCreatedEvent.eventType())
        .as("Expected event type to be %s", bookingEventType)
        .isEqualTo(bookingEventType);
    assertThat(bookingCreatedEvent.bookingId())
        .as("Expected booking ID to match output booking ID")
        .isEqualTo(bookingOutput.bookingId());
  }

  /**
   * Asserts that the booking output is valid and matches the expected status.
   *
   * @param output the booking output to validate
   * @param expectedStatus the expected {@link BookingStatus}
   * @param desc a custom description used for the assertion error message
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static void thenBookingOutputValid(
      BookingOutput output, BookingStatus expectedStatus, String desc) {
    assertThat(output).as("BookingOutput should not be null").isNotNull();

    assertThat(output.bookingId()).as("BookingOutput.bookingId should not be null").isNotNull();

    assertThat(output.status()).as(desc).isEqualTo(expectedStatus);
  }
}

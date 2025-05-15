package com.github.j4c62.pms.booking.application.acceptance.cancel.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenBookingOutputValid;
import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenTheEventIsPublished;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.mockito.ArgumentCaptor;

/**
 * JGiven 'Then' stage that verifies the booking has been marked as cancelled and that the
 * appropriate event has been published to notify the user.
 *
 * <p>This stage checks that the {@link BookingOutput} reflects a cancelled state, and verifies that
 * a {@link BookingEvent} of type {@code BOOKING_CANCELLED} was published.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified {
  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;

  /**
   * Asserts that the booking status was updated to {@code CANCELLED} and that a cancellation event
   * was published.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theBookingStatusIsUpdatedAndTheUserIsNotified() {
    thenTheEventIsPublished(
        setUpFixture.bookingEventPublisher(),
        1,
        bookingEventArgumentCaptor,
        BOOKING_CANCELLED,
        bookingOutput);
    thenBookingOutputValid(bookingOutput, CANCELLED, "status is Cancelled");
  }
}

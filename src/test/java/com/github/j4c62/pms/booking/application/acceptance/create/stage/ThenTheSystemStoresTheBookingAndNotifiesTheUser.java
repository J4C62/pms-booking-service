package com.github.j4c62.pms.booking.application.acceptance.create.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenBookingOutputValid;
import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenTheEventIsPublished;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_CREATED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.mockito.ArgumentCaptor;

/**
 * JGiven 'Then' stage that verifies the system has persisted the booking and notified the user.
 *
 * <p>This stage validates that:
 *
 * <ul>
 *   <li>A {@link BookingEvent} of type {@code BOOKING_CREATED} was published.
 *   <li>The {@link BookingOutput} returned is valid and its status is {@code PENDING}.
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class ThenTheSystemStoresTheBookingAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;

  /**
   * Verifies that the booking was saved correctly and the user was notified by publishing the
   * appropriate event.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theBookingIsSavedAndUserIsNotified() {
    thenTheEventIsPublished(
        setUpFixture.bookingEventPublisher(),
        1,
        bookingEventArgumentCaptor,
        BOOKING_CREATED,
        bookingOutput);
    thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");
  }
}

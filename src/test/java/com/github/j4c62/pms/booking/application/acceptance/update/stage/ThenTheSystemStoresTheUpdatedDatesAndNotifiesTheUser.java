package com.github.j4c62.pms.booking.application.acceptance.update.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenBookingOutputValid;
import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenTheEventIsPublished;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_UPDATED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.mockito.ArgumentCaptor;

/**
 * JGiven 'Then' stage that verifies the system stores the updated booking dates and notifies the
 * user appropriately.
 *
 * <p>This stage performs two validations:
 *
 * <ul>
 *   <li>Asserts that a {@link BookingEvent} of type {@code BOOKING_UPDATED} was published exactly
 *       once.
 *   <li>Verifies that the {@link BookingOutput} is valid and has a {@code PENDING} status.
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-21
 */
@JGivenStage
public class ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;

  /**
   * Verifies that the updated booking dates were stored and the user was notified via a published
   * event.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-21
   */
  public void theUpdatedDatesAreSavedAndTheUserIsNotified() {
    thenTheEventIsPublished(
        setUpFixture.bookingEventPublisher(),
        1,
        bookingEventArgumentCaptor,
        BOOKING_UPDATED,
        bookingOutput);
    thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");
  }
}

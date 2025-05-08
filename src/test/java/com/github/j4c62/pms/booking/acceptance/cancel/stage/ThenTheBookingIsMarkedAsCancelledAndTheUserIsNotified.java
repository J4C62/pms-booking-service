package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
    extends Stage<ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {
  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState Fixture.SetUpFixture setUpFixture;

  public ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
      the_booking_status_is_updated_and_the_user_is_notified() {
    BookingTestUtils.thenBookingOutputValid(bookingOutput, CANCELLED, "status is Cancelled");
    BookingTestUtils.thenEventsPublished(
        2, 1, setUpFixture.bookingEventPublisher(), BookingCancelledEvent.class);
    return this;
  }
}

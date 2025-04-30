package com.github.j4c62.pms.booking.acceptance.update.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
    extends Stage<ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState Fixture.SetUpFixture setUpFixture;

  public ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
      the_updated_dates_are_saved_and_the_user_is_notified() {
    BookingTestUtils.thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");
    BookingTestUtils.thenEventsPublished(
        2, 1, setUpFixture.bookingEventPublisher(), BookingUpdateEvent.class);
    return self();
  }
}

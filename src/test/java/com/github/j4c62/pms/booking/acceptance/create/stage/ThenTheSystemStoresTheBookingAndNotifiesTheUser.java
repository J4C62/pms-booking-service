package com.github.j4c62.pms.booking.acceptance.create.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheSystemStoresTheBookingAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState Fixture.SetUpFixture setUpFixture;

  public ThenTheSystemStoresTheBookingAndNotifiesTheUser
      the_booking_is_saved_and_user_is_notified() {
    BookingTestUtils.thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");
    BookingTestUtils.thenEventsPublished(
        1, 0, setUpFixture.bookingEventPublisher(), BookingCreatedEvent.class);
    return this;
  }
}

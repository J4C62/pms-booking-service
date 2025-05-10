package com.github.j4c62.pms.booking.application.acceptance.create.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenTheEventIsPublished;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.BookingTestUtils;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.mockito.ArgumentCaptor;

@JGivenStage
public class ThenTheSystemStoresTheBookingAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;

  public ThenTheSystemStoresTheBookingAndNotifiesTheUser
      the_booking_is_saved_and_user_is_notified() {
    thenTheEventIsPublished(
        setUpFixture.bookingEventPublisher(),
        1,
        bookingEventArgumentCaptor,
        BookingEventType.BOOKING_CREATED,
        bookingOutput);
    BookingTestUtils.thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");

    return this;
  }
}

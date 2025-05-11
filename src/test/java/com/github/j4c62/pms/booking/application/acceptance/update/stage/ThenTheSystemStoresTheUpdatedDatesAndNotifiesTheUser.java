package com.github.j4c62.pms.booking.application.acceptance.update.stage;

import static com.github.j4c62.pms.booking.application.BookingTestUtils.thenTheEventIsPublished;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.BookingTestUtils;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.mockito.ArgumentCaptor;

public class ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
    extends Stage<ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState ApplicationFixture.SetUpFixture setUpFixture;

  public ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
      the_updated_dates_are_saved_and_the_user_is_notified() {
    thenTheEventIsPublished(
        setUpFixture.bookingEventPublisher(),
        1,
        bookingEventArgumentCaptor,
        BookingEventType.BOOKING_UPDATED,
        bookingOutput);
    BookingTestUtils.thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");

    return self();
  }
}

package com.github.j4c62.pms.booking.acceptance.create.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.mockito.ArgumentCaptor;

@JGivenStage
public class ThenTheSystemStoresTheBookingAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState BookingEventPublisher bookingEventPublisher;

  public ThenTheSystemStoresTheBookingAndNotifiesTheUser
      the_booking_is_saved_and_user_is_notified() {
    verify(bookingEventPublisher).publish(bookingEventArgumentCaptor.capture());
    var bookingCreatedEvent = bookingEventArgumentCaptor.getValue();
    assertThat(bookingCreatedEvent.eventType()).isEqualTo(BookingEventType.BOOKING_CREATED);
    assertThat(bookingCreatedEvent.bookingId()).isEqualTo(bookingOutput.bookingId());
    BookingTestUtils.thenBookingOutputValid(bookingOutput, PENDING, "status is Pending");

    return this;
  }
}

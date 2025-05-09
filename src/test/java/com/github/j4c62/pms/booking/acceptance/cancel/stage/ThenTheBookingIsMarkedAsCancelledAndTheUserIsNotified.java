package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.mockito.ArgumentCaptor;

public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
    extends Stage<ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {
  @ExpectedScenarioState BookingOutput bookingOutput;
  @ExpectedScenarioState ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ExpectedScenarioState BookingEventPublisher bookingEventPublisher;

  public ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
      the_booking_status_is_updated_and_the_user_is_notified() {
    verify(bookingEventPublisher, times(2)).publish(bookingEventArgumentCaptor.capture());
    var bookingCreatedEvent = bookingEventArgumentCaptor.getValue();
    assertThat(bookingCreatedEvent.eventType()).isEqualTo(BookingEventType.BOOKING_CANCELLED);
    assertThat(bookingCreatedEvent.bookingId()).isEqualTo(bookingOutput.bookingId());
    BookingTestUtils.thenBookingOutputValid(bookingOutput, CANCELLED, "status is Cancelled");

    return this;
  }
}

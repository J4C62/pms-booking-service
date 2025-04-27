package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.shared.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.UUID;

public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
    extends Stage<ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {
  @ExpectedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;
  @ExpectedScenarioState UUID bookingId;

  @ExpectedScenarioState FakeBookingEventPublisher fakeBookingEventPublisher;

  public ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
      the_booking_status_is_updated_and_the_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(eventStore.getEventsForBooking(new BookingId(bookingId)).events())
        .hasSizeGreaterThan(0)
        .anyMatch(BookingCancelledEvent.class::isInstance);
    assertThat(fakeBookingEventPublisher.getPublishedEvents())
        .isNotEmpty()
        .anyMatch(BookingCancelledEvent.class::isInstance);
    return self();
  }
}

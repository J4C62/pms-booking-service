package com.github.j4c62.pms.booking.acceptance.create.stage;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheSystemStoresTheBookingAndNotifiesTheUser
    extends Stage<ThenTheSystemStoresTheBookingAndNotifiesTheUser> {

  @ExpectedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryEventStoreDecorator eventStore;
  @ExpectedScenarioState FakeBookingEventPublisher fakeBookingEventPublisher;

  public ThenTheSystemStoresTheBookingAndNotifiesTheUser
      the_booking_is_saved_and_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(eventStore.getEventsForBooking(new BookingId(bookingOutput.bookingId())).events())
        .isNotEmpty()
        .anyMatch(BookingCreatedEvent.class::isInstance);
    assertThat(fakeBookingEventPublisher.getPublishedEvents())
        .isNotEmpty()
        .anyMatch(BookingCreatedEvent.class::isInstance);
    return self();
  }
}

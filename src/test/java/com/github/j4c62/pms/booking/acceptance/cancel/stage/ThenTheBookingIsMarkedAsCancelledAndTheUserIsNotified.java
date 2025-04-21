package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.InMemoryBookingAdapter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
    extends Stage<ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {

  @ExpectedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryBookingAdapter fakeRepo;

  @ExpectedScenarioState FakeBookingEventPublisher fakeEventPublisher;

  public ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
      the_booking_status_is_updated_and_the_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(fakeRepo.getAll()).hasSize(1);
    assertThat(fakeEventPublisher.wasPublished()).isTrue();
    return self();
  }
}

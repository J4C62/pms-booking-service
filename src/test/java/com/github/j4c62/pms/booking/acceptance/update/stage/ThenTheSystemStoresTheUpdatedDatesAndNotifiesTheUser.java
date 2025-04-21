package com.github.j4c62.pms.booking.acceptance.update.stage;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.InMemoryBookingAdapter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
    extends Stage<ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {

  @ExpectedScenarioState BookingOutput bookingOutput;

  @ExpectedScenarioState InMemoryBookingAdapter fakeRepo;

  @ExpectedScenarioState FakeBookingEventPublisher fakeEventPublisher;

  public ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
      the_updated_dates_are_saved_and_the_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(fakeRepo.getAll()).hasSize(1);
    assertThat(fakeEventPublisher.wasPublished()).isTrue();
    return self();
  }
}

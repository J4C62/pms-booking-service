package com.github.j4c62.pms.booking.acceptance.update.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
    extends Stage<ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {

  @ExpectedScenarioState BookingOutput bookingOutput;

  public ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser
      the_updated_dates_are_saved_and_the_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(bookingOutput.status()).isEqualTo(PENDING);
    return self();
  }
}

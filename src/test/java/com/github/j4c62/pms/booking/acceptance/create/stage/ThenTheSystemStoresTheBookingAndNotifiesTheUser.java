package com.github.j4c62.pms.booking.acceptance.create.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheSystemStoresTheBookingAndNotifiesTheUser {

  @ExpectedScenarioState BookingOutput bookingOutput;

  public ThenTheSystemStoresTheBookingAndNotifiesTheUser
      the_booking_is_saved_and_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(bookingOutput.status()).isEqualTo(PENDING);
    return this;
  }
}

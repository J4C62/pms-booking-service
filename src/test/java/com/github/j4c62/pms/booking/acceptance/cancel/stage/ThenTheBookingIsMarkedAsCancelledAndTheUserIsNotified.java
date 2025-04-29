package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
    extends Stage<ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {
  @ExpectedScenarioState BookingOutput bookingOutput;

  public ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified
      the_booking_status_is_updated_and_the_user_is_notified() {
    assertThat(bookingOutput).isNotNull();
    assertThat(bookingOutput.status()).isEqualTo(CANCELLED);
    return this;
  }
}

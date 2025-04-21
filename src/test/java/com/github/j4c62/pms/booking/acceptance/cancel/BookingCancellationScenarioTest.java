package com.github.j4c62.pms.booking.acceptance.cancel;

import com.github.j4c62.pms.booking.acceptance.cancel.stage.GivenAUserWantsToCancelABooking;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.WhenTheUserCancelsTheBooking;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class BookingCancellationScenarioTest
    extends ScenarioTest<
        GivenAUserWantsToCancelABooking,
        WhenTheUserCancelsTheBooking,
        ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {

  @Test
  void user_can_cancel_a_booking_successfully() {
    given().the_user_provides_a_valid_booking_id();
    when().the_booking_is_cancelled();
    then().the_booking_status_is_updated_and_the_user_is_notified();
  }
}

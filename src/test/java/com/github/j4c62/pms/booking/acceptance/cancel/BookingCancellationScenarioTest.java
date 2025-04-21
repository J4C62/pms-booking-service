package com.github.j4c62.pms.booking.acceptance.cancel;

import com.github.j4c62.pms.booking.acceptance.cancel.stage.GivenAUserWantsToCancelABook;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.ThenTheSystemRespondsWithSuccess;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.WhenUserCancelTheBooking;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class BookingCancellationScenarioTest
    extends ScenarioTest<
        GivenAUserWantsToCancelABook, WhenUserCancelTheBooking, ThenTheSystemRespondsWithSuccess> {

  @Test
  void user_can_cancel_a_booking_successfully() {
    given().the_user_provides_valid_booking_id();
    when().the_booking_is_cancel();
    then().the_booking_is_update_and_user_is_notified();
  }
}

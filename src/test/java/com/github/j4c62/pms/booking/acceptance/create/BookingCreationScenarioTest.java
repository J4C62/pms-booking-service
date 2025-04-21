package com.github.j4c62.pms.booking.acceptance.create;

import com.github.j4c62.pms.booking.acceptance.create.stage.GivenAUserWantsToBook;
import com.github.j4c62.pms.booking.acceptance.create.stage.ThenTheSystemRespondsWithSuccess;
import com.github.j4c62.pms.booking.acceptance.create.stage.WhenTheUserMakesTheBooking;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class BookingCreationScenarioTest
    extends ScenarioTest<
        GivenAUserWantsToBook, WhenTheUserMakesTheBooking, ThenTheSystemRespondsWithSuccess> {

  @Test
  void user_can_create_a_booking_successfully() {
    given().the_user_provides_valid_booking_details();
    when().the_booking_is_created();
    then().the_booking_is_saved_and_user_is_notified();
  }
}

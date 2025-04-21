package com.github.j4c62.pms.booking.acceptance.create;

import com.github.j4c62.pms.booking.acceptance.create.stage.GivenAUserWantsToMakeABooking;
import com.github.j4c62.pms.booking.acceptance.create.stage.ThenTheSystemStoresTheBookingAndNotifiesTheUser;
import com.github.j4c62.pms.booking.acceptance.create.stage.WhenTheUserSubmitsTheBooking;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class BookingCreationScenarioTest
    extends ScenarioTest<
        GivenAUserWantsToMakeABooking,
        WhenTheUserSubmitsTheBooking,
        ThenTheSystemStoresTheBookingAndNotifiesTheUser> {

  @Test
  void user_can_create_a_booking_successfully() {
    given().the_user_provides_valid_booking_details();
    when().the_booking_is_created();
    then().the_booking_is_saved_and_user_is_notified();
  }
}

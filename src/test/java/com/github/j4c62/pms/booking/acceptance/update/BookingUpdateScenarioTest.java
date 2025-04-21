package com.github.j4c62.pms.booking.acceptance.update;

import com.github.j4c62.pms.booking.acceptance.update.stage.GivenAUserWantsToModifyBookingDates;
import com.github.j4c62.pms.booking.acceptance.update.stage.ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser;
import com.github.j4c62.pms.booking.acceptance.update.stage.WhenTheUserUpdatesTheBooking;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class BookingUpdateScenarioTest
    extends ScenarioTest<
        GivenAUserWantsToModifyBookingDates,
        WhenTheUserUpdatesTheBooking,
        ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {

  @Test
  void user_can_update_a_booking_successfully() {
    given().the_user_provides_valid_new_booking_dates();
    when().the_booking_is_updated();
    then().the_updated_dates_are_saved_and_the_user_is_notified();
  }
}

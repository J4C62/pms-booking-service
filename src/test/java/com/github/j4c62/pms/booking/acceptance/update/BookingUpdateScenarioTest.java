package com.github.j4c62.pms.booking.acceptance.update;

import com.github.j4c62.pms.booking.acceptance.update.stage.GivenAUserWantsToModifyBookingDates;
import com.github.j4c62.pms.booking.acceptance.update.stage.ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser;
import com.github.j4c62.pms.booking.acceptance.update.stage.WhenTheUserUpdatesTheBooking;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.junit5.SpringScenarioTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(Fixture.class)
class BookingUpdateScenarioTest
    extends SpringScenarioTest<
        GivenAUserWantsToModifyBookingDates,
        WhenTheUserUpdatesTheBooking,
        ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {
  @ProvidedScenarioState @Autowired Fixture.SetUpFixture setUpFixture;

  @AfterEach
  void tearDown() {
    BookingTestUtils.reset(setUpFixture);
  }

  @Test
  void user_can_update_a_booking_successfully() {
    given().the_user_provides_valid_new_booking_dates_and_booking_exits();
    when().the_booking_is_updated();
    then().the_updated_dates_are_saved_and_the_user_is_notified();
  }
}

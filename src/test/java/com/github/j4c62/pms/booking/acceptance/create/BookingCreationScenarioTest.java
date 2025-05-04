package com.github.j4c62.pms.booking.acceptance.create;

import com.github.j4c62.pms.booking.acceptance.create.stage.GivenAUserWantsToMakeABooking;
import com.github.j4c62.pms.booking.acceptance.create.stage.ThenTheSystemStoresTheBookingAndNotifiesTheUser;
import com.github.j4c62.pms.booking.acceptance.create.stage.WhenTheUserSubmitsTheBooking;
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
class BookingCreationScenarioTest
    extends SpringScenarioTest<
        GivenAUserWantsToMakeABooking,
        WhenTheUserSubmitsTheBooking,
        ThenTheSystemStoresTheBookingAndNotifiesTheUser> {

  @ProvidedScenarioState @Autowired Fixture.SetUpFixture setUpFixture;

  @AfterEach
  void tearDown() {
    BookingTestUtils.reset(setUpFixture);
  }

  @Test
  void user_can_create_a_booking_successfully() {
    given().the_user_provides_valid_booking_details();
    when().the_booking_is_created();
    then().the_booking_is_saved_and_user_is_notified();
  }
}

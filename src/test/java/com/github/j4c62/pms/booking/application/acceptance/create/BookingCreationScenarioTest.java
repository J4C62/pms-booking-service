package com.github.j4c62.pms.booking.application.acceptance.create;

import static org.mockito.Mockito.reset;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.acceptance.create.stage.GivenAUserWantsToMakeABooking;
import com.github.j4c62.pms.booking.application.acceptance.create.stage.ThenTheSystemStoresTheBookingAndNotifiesTheUser;
import com.github.j4c62.pms.booking.application.acceptance.create.stage.WhenTheUserSubmitsTheBooking;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.junit5.SpringScenarioTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(ApplicationFixture.class)
class BookingCreationScenarioTest
    extends SpringScenarioTest<
        GivenAUserWantsToMakeABooking,
        WhenTheUserSubmitsTheBooking,
        ThenTheSystemStoresTheBookingAndNotifiesTheUser> {

  @ProvidedScenarioState @Autowired ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState @Captor ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;

  @BeforeEach
  void resetMocks() {
    reset(setUpFixture.bookingEventPublisher());
  }

  @Test
  void user_can_create_a_booking_successfully() {
    given().the_user_provides_valid_booking_details();
    when().the_booking_is_created();
    then().the_booking_is_saved_and_user_is_notified();
  }
}

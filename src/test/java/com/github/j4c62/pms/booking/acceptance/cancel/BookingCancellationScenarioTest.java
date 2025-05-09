package com.github.j4c62.pms.booking.acceptance.cancel;

import com.github.j4c62.pms.booking.acceptance.cancel.stage.GivenAUserWantsToCancelABooking;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified;
import com.github.j4c62.pms.booking.acceptance.cancel.stage.WhenTheUserCancelsTheBooking;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.utils.BookingTestUtils;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.junit5.SpringScenarioTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(Fixture.class)
class BookingCancellationScenarioTest
    extends SpringScenarioTest<
        GivenAUserWantsToCancelABooking,
        WhenTheUserCancelsTheBooking,
        ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {

  @ProvidedScenarioState @Autowired Fixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState @Captor ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;
  @ProvidedScenarioState @MockitoBean BookingEventPublisher bookingEventPublisher;

  @AfterEach
  void tearDown() {
    BookingTestUtils.reset(setUpFixture);
  }

  @Test
  void user_can_cancel_a_booking_successfully() {
    given().the_user_provides_a_valid_booking_id();
    when().the_booking_is_cancelled();
    then().the_booking_status_is_updated_and_the_user_is_notified();
  }
}

package com.github.j4c62.pms.booking.application.acceptance.cancel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.acceptance.cancel.stage.GivenUserWantsToCancelBooking;
import com.github.j4c62.pms.booking.application.acceptance.cancel.stage.ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified;
import com.github.j4c62.pms.booking.application.acceptance.cancel.stage.WhenTheUserCancelsTheBooking;
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
class BookingCancellationScenarioTest
    extends SpringScenarioTest<
        GivenUserWantsToCancelBooking,
        WhenTheUserCancelsTheBooking,
        ThenTheBookingIsMarkedAsCancelledAndTheUserIsNotified> {

  @ProvidedScenarioState @Autowired ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState @Captor ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;

  @BeforeEach
  void resetMocks() {
    reset(setUpFixture.bookingEventPublisher());
  }

  @Test
  void userCanCancelBookingSuccessfully() {
    given().theUserProvidesValidBookingId();
    when().theBookingIsCancelled();
    then().theBookingStatusIsUpdatedAndTheUserIsNotified();
    assertThat(setUpFixture).isNotNull();
  }
}

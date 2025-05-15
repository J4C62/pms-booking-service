package com.github.j4c62.pms.booking.application.acceptance.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.acceptance.update.stage.GivenUserWantsToModifyBookingDates;
import com.github.j4c62.pms.booking.application.acceptance.update.stage.ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser;
import com.github.j4c62.pms.booking.application.acceptance.update.stage.WhenTheUserUpdatesTheBooking;
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
class BookingUpdateScenarioTest
    extends SpringScenarioTest<
        GivenUserWantsToModifyBookingDates,
        WhenTheUserUpdatesTheBooking,
        ThenTheSystemStoresTheUpdatedDatesAndNotifiesTheUser> {
  @ProvidedScenarioState @Autowired ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState @Captor ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;

  @BeforeEach
  void resetMocks() {
    reset(setUpFixture.bookingEventPublisher());
  }

  @Test
  void userCanUpdateBookingSuccessfully() {
    given().theUserProvidesValidNewBookingDatesAndBookingExits();
    when().theBookingIsUpdated();
    then().theUpdatedDatesAreSavedAndTheUserIsNotified();
    assertThat(setUpFixture).isNotNull();
  }
}

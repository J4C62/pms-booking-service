package com.github.j4c62.pms.booking.application.acceptance.create;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.acceptance.create.stage.GivenUserWantsToMakeBooking;
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
        GivenUserWantsToMakeBooking,
        WhenTheUserSubmitsTheBooking,
        ThenTheSystemStoresTheBookingAndNotifiesTheUser> {

  @ProvidedScenarioState @Autowired ApplicationFixture.SetUpFixture setUpFixture;
  @ProvidedScenarioState @Captor ArgumentCaptor<BookingEvent> bookingEventArgumentCaptor;

  @BeforeEach
  void resetMocks() {
    reset(setUpFixture.bookingEventPublisher());
  }

  @Test
  void userCanCreateBookingSuccessfully() {
    given().theUserProvidesValidBookingDetails();
    when().theBookingIsCreated();
    then().theBookingIsSavedAndUserIsNotified();
    assertThat(setUpFixture).isNotNull();
  }
}

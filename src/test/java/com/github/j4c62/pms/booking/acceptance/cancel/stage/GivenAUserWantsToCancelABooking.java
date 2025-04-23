package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenAUserWantsToCancelABooking extends Stage<GivenAUserWantsToCancelABooking> {

  @ProvidedScenarioState CreateBookingInput createBookingInput;

  public GivenAUserWantsToCancelABooking the_user_provides_a_valid_booking_id() {
//    createBookingInput = new CreateBookingInput();
//    createBookingInput.setPropertyId(UUID.randomUUID());
//    createBookingInput.setGuestId(UUID.randomUUID());
//    createBookingInput.setStartDate(String.valueOf(LocalDate.now()));
//    createBookingInput.setEndDate(String.valueOf(LocalDate.now().plusDays(2)));

    return self();
  }
}

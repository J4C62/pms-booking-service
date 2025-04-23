package com.github.j4c62.pms.booking.acceptance.create.stage;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenAUserWantsToMakeABooking extends Stage<GivenAUserWantsToMakeABooking> {

  @ProvidedScenarioState CreateBookingInput createBookingInput;

  public GivenAUserWantsToMakeABooking the_user_provides_valid_booking_details() {
    createBookingInput = new CreateBookingInput();
    //    createBookingInput.setPropertyId(UUID.randomUUID());
    //    createBookingInput.setGuestId(UUID.randomUUID());
    //    createBookingInput.setStartDate(String.valueOf(LocalDate.now()));
    //    createBookingInput.setEndDate(String.valueOf(LocalDate.now().plusDays(2)));

    return self();
  }
}

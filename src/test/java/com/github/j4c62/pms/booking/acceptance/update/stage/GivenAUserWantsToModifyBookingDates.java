package com.github.j4c62.pms.booking.acceptance.update.stage;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.time.LocalDate;
import java.util.UUID;

public class GivenAUserWantsToModifyBookingDates
    extends Stage<GivenAUserWantsToModifyBookingDates> {

  @ProvidedScenarioState CreateBookingInput createBookingInput;

  public GivenAUserWantsToModifyBookingDates the_user_provides_valid_new_booking_dates() {
    createBookingInput = new CreateBookingInput();
    createBookingInput.setPropertyId(UUID.randomUUID());
    createBookingInput.setGuestId(UUID.randomUUID());
    createBookingInput.setStartDate(String.valueOf(LocalDate.now()));
    createBookingInput.setEndDate(String.valueOf(LocalDate.now().plusDays(2)));

    return self();
  }
}

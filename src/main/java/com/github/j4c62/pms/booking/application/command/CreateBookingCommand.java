package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CreateBookingCommand extends CreateBookingInput {
  public CreateBookingCommand(String propertyId, String guestId, String startDate, String endDate) {
    setPropertyId(propertyId);
    setGuestId(guestId);
    setStartDate(startDate);
    setEndDate(endDate);
  }
}

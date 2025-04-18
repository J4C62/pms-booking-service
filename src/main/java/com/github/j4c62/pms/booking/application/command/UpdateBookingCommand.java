package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpdateBookingCommand extends UpdateBookingInput {
  public UpdateBookingCommand(
      String bookingId, String newStartDate, String newEndDate, String updateReason) {
    setBookingId(bookingId);
    setNewStartDate(newStartDate);
    setNewEndDate(newEndDate);
    setUpdateReason(updateReason);
  }
}

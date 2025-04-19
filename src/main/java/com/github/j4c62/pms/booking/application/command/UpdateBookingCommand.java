package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpdateBookingCommand extends UpdateBookingInput {
  public UpdateBookingCommand(
      UUID bookingId,
      String newStartDate,
      String newEndDate,
      String updateReason,
      String updateAt) {
    setBookingId(bookingId);
    setNewStartDate(newStartDate);
    setNewEndDate(newEndDate);
    setUpdateReason(updateReason);
    setUpdateAt(updateAt);
  }
}

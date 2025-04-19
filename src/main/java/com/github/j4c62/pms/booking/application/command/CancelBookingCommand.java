package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CancelBookingCommand extends CancelBookingInput {
  public CancelBookingCommand(String bookingId, String reason, String cancelledBy) {
    setBookingId(bookingId);
    setReason(reason);
    setCancelledBy(cancelledBy);
  }
}

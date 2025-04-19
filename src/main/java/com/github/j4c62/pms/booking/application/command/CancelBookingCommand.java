package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CancelBookingCommand extends CancelBookingInput {
  public CancelBookingCommand(UUID bookingId, String reason, String cancelledBy) {
    setBookingId(bookingId);
    setReason(reason);
    setCancelledBy(cancelledBy);
  }
}

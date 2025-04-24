package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpdateBookingCommand extends UpdateBookingInput {
  public UpdateBookingCommand(
      BookingId bookingId, BookingDates bookingDates, String updateReason, String updateAt) {
    setBookingId(bookingId);
    setBookingDates(bookingDates);
    setUpdateReason(updateReason);
    setUpdateAt(updateAt);
  }
}

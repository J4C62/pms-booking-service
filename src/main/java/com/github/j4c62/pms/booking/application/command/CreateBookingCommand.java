package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CreateBookingCommand extends CreateBookingInput {
  public CreateBookingCommand(UUID propertyId, UUID guestId, LocalDate startDate, LocalDate endDate) {
    setPropertyId(new PropertyId(propertyId));
    setGuestId(new GuestId(guestId));
    setBookingDates(new BookingDates(startDate, endDate));
  }
}

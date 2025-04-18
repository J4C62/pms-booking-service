package com.github.j4c62.pms.booking.application.creation.assembler;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.actualDate;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingEventAssembler {

  public BookingCreated toBookingCreated(Booking booking) {
    return new BookingCreated(
        booking.bookingId(),
        booking.propertyId(),
        booking.guestId(),
        booking.startDate(),
        booking.endDate());
  }

  public BookingCancelled toBookingCancelled(
      Booking booking, CancelBookingInput cancelBookingInput) {
    return new BookingCancelled(
        booking.bookingId(),
        booking.propertyId(),
        booking.startDate(),
        booking.endDate(),
        cancelBookingInput.getReason(),
        cancelBookingInput.getCancelledBy(),
        cancelBookingInput.getCancelledAt());
  }

  public BookingUpdated toBookingUpdated(Booking booking, UpdateBookingInput updateBookingInput) {
    return new BookingUpdated(
        booking.bookingId(),
        booking.startDate(),
        booking.endDate(),
        updateBookingInput.getNewStartDate(),
        updateBookingInput.getNewEndDate(),
        actualDate(),
        updateBookingInput.getUpdateReason());
  }
}

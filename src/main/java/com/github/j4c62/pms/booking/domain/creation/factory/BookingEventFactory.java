package com.github.j4c62.pms.booking.domain.creation.factory;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.actualDate;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;

public class BookingEventFactory {

  public static BookingEventFactory createBookingFactory() {
    return new BookingEventFactory();
  }

  public BookingCreated createBookingCreated(Booking booking) {

    return new BookingCreated(
        booking.bookingId(),
        booking.propertyId(),
        booking.guestId(),
        booking.startDate(),
        booking.endDate());
  }

  public BookingCancelled createBookingCancelled(
      Booking booking, CancelBookingInput cancelBookingInput) {

    return new BookingCancelled(
        booking.bookingId(),
        booking.propertyId(),
        booking.guestId(),
        booking.startDate(),
        booking.endDate(),
        cancelBookingInput.getReason(),
        cancelBookingInput.getCancelledBy(),
        cancelBookingInput.getCancelledAt());
  }

  public BookingUpdated createBookingUpdated(
      Booking booking, UpdateBookingInput updateBookingInput) {

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

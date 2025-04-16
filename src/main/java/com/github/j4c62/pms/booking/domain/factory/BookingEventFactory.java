package com.github.j4c62.pms.booking.domain.factory;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.actualDate;

import com.github.j4c62.pms.booking.application.dto.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;

public class BookingEventFactory {

  public static BookingEventFactory createBookingFactory() {
    return new BookingEventFactory();
  }

  public BookingCreated createBookingCreate(Booking booking) {

    return new BookingCreated(
        booking.bookingId(),
        booking.propertyId(),
        booking.guestId(),
        booking.startDate(),
        booking.endDate());
  }

  public BookingUpdated createBookingUpdated(
      Booking booking, UpdateBookingCommand updateBookingCommand) {

    return new BookingUpdated(
        booking.bookingId(),
        booking.startDate(),
        booking.endDate(),
        updateBookingCommand.newStartDate(),
        updateBookingCommand.newEndDate(),
        actualDate(),
        updateBookingCommand.updateReason());
  }
}

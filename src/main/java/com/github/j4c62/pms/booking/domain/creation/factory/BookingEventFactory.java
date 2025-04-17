package com.github.j4c62.pms.booking.domain.creation.factory;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.actualDate;

import com.github.j4c62.pms.booking.domain.driver.request.CancelBookingRequest;
import com.github.j4c62.pms.booking.domain.driver.request.UpdateBookingRequest;
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
      Booking booking, CancelBookingRequest cancelBookingRequest) {

    return new BookingCancelled(
        booking.bookingId(),
        booking.propertyId(),
        booking.guestId(),
        booking.startDate(),
        booking.endDate(),
        cancelBookingRequest.reason(),
        cancelBookingRequest.cancelledBy(),
        cancelBookingRequest.cancelledAt());
  }

  public BookingUpdated createBookingUpdated(
      Booking booking, UpdateBookingRequest updateBookingRequest) {

    return new BookingUpdated(
        booking.bookingId(),
        booking.startDate(),
        booking.endDate(),
        updateBookingRequest.newStartDate(),
        updateBookingRequest.newEndDate(),
        actualDate(),
        updateBookingRequest.updateReason());
  }
}

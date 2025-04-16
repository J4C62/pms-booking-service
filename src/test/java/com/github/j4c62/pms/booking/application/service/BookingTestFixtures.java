package com.github.j4c62.pms.booking.application.service;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.model.Booking;

public class BookingTestFixtures {

  private static final BookingFactory factory = BookingFactory.createBookingFactory();

  public static Booking createBooking() {
    var command = new CreateBookingCommand("property-456", "guest-789", "2025-05-01", "2025-05-05");
    return factory.create(command);
  }

  public static Booking pendingBooking() {
    return createBooking().markAsPending();
  }

  public static Booking confirmedBooking() {
    return createBooking().confirm();
  }

  public static Booking cancelledBooking() {
    return createBooking().cancel();
  }

  public static Booking bookingWithDates(String start, String end) {
    return createBooking().updateDates(start, end);
  }
}

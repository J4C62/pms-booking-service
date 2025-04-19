package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.model.Booking;
import java.util.UUID;

public interface BookingRepository {
  Booking save(Booking booking);

  Integer updateCanceledBooking(UUID bookingId);

  int updateBookingDates(UUID bookingId, String newStartDate, String newEndDate);

  void deleteById(UUID bookingId);
}

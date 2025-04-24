package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.model.Booking;
import java.time.LocalDate;
import java.util.UUID;

public interface BookingRepository {
  Booking save(Booking booking);

  Integer updateCanceledBooking(UUID bookingId);

  int updateBookingDates(UUID bookingId, LocalDate newStartDate, LocalDate newEndDate);

  void deleteById(UUID bookingId);
}

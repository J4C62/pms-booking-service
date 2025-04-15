package com.github.j4c62.pms.booking.domain.repository;

import com.github.j4c62.pms.booking.domain.model.Booking;

import java.util.Optional;

public interface BookingRepository {
  Booking save(Booking booking);
  Optional<Booking> findById(String bookingId);
  void deleteById(String bookingId);
}

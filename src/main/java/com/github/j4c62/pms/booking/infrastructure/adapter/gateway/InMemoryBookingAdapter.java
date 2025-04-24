package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import java.time.LocalDate;
import java.util.*;

public class InMemoryBookingAdapter implements BookingRepository {
  private final Map<UUID, Booking> bookings = new HashMap<>();

  @Override
  public Booking save(Booking booking) {
    bookings.put(booking.bookingId(), booking);
    return booking;
  }

  @Override
  public Integer updateCanceledBooking(UUID bookingId) {
    Booking booking = bookings.get(bookingId);
    if (booking != null && !booking.isCancelled()) {
      booking.cancel();
      return 1;
    }
    return 0;
  }

  @Override
  public int updateBookingDates(UUID bookingId, LocalDate newStartDate, LocalDate newEndDate) {
    Booking booking = bookings.get(bookingId);
    if (booking != null) {
      booking.validateUpdatable(newStartDate, newEndDate);
      booking.updateDates(newStartDate, newEndDate);
      return 1;
    }
    return 0;
  }

  @Override
  public void deleteById(UUID bookingId) {
    bookings.remove(bookingId);
  }

  public List<Booking> getAll() {
    return new ArrayList<>(bookings.values());
  }
}

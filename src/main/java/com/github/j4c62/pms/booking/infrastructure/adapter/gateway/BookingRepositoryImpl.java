package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
  @Override
  public Booking save(Booking booking) {
    return null;
  }

  @Override
  public Optional<Booking> findById(String bookingId) {
    return Optional.empty();
  }

  @Override
  public void deleteById(String bookingId) {}
}

package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper.BookingMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingJpaProvider;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgreSqlAdapter implements BookingRepository {

  private final BookingJpaProvider bookingJpaProvider;
  private final BookingMapper bookingMapper;

  @Override
  public Booking save(Booking booking) {
    var entity = bookingMapper.toEntity(booking);
    var savedEntity = bookingJpaProvider.save(entity);
    return bookingMapper.toDomain(savedEntity);
  }

  @Override
  public Integer updateCanceledBooking(UUID bookingId) {
    return bookingJpaProvider.cancelBooking(bookingId);
  }

  @Override
  public int updateBookingDates(UUID bookingId, LocalDate newStartDate, LocalDate newEndDate) {
    return bookingJpaProvider.updateBookingDates(bookingId, newStartDate, newEndDate);
  }

  @Override
  public void deleteById(UUID bookingId) {
    bookingJpaProvider.deleteById(bookingId);
  }
}

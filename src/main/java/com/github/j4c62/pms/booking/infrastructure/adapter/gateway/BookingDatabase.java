package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper.BookingMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingJpaProvider;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookingDatabase implements BookingRepository {

  private final BookingJpaProvider bookingJpaProvider;
  private final BookingMapper bookingMapper;

  @Override
  public Booking save(Booking booking) {
    var entity = bookingMapper.toEntity(booking);
    var savedEntity = bookingJpaProvider.save(entity);
    return bookingMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Booking> findById(String bookingId) {
    return bookingJpaProvider.findById(bookingId).map(bookingMapper::toDomain);
  }

  @Override
  public void deleteById(String bookingId) {
    bookingJpaProvider.deleteById(bookingId);
  }
}

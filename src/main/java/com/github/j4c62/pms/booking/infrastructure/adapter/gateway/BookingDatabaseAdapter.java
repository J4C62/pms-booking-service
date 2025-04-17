package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.entity.BookingEntity;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper.BookingMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookingDatabaseAdapter implements BookingRepository {

  private final BookingEntityJpaRepository bookingEntityJpaRepository;
  private final BookingMapper bookingMapper;

  @Override
  public Booking save(Booking booking) {
    BookingEntity entity = bookingMapper.toEntity(booking);
    BookingEntity savedEntity = bookingEntityJpaRepository.save(entity);
    return bookingMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Booking> findById(String bookingId) {
    return bookingEntityJpaRepository.findById(bookingId)
        .map(bookingMapper::toDomain);
  }

  @Override
  public void deleteById(String bookingId) {
    bookingEntityJpaRepository.deleteById(bookingId);
  }
}

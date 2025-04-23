package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingEventJpaRepository extends JpaRepository<BookingEventEntity, Long> {
  List<BookingEventEntity> findByBookingIdOrderByOccurredAtAsc(UUID bookingId);
}

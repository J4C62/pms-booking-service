package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingSnapshotEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSnapshotJpaRepository extends JpaRepository<BookingSnapshotEntity, Long> {
  Optional<BookingSnapshotEntity> findTopByBookingIdOrderByCreatedAtDesc(UUID bookingId);
}


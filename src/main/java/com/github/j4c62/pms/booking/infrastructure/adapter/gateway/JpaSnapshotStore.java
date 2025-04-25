package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.converter.JsonConverter;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingSnapshotJpaRepository;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingSnapshotEntity;
import java.time.Instant;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaSnapshotStore implements SnapshotStore {

  private final BookingSnapshotJpaRepository snapshotRepository;
  private final JsonConverter jsonConverter;

  @Override
  public void saveSnapshot(BookingSnapshot snapshot) {
    BookingSnapshotEntity entity = new BookingSnapshotEntity();
    entity.setId(null);
    entity.setBookingId(snapshot.bookingId().value());
    entity.setSnapshot(jsonConverter.toJson(snapshot));
    entity.setCreatedAt(Instant.now());

    snapshotRepository.save(entity);
  }

  @Override
  public Optional<BookingSnapshot> getLatestSnapshot(BookingId bookingId) {
    return snapshotRepository
        .findTopByBookingIdOrderByCreatedAtDesc(bookingId.value())
        .map(e -> jsonConverter.fromJson(e.getSnapshot(), BookingSnapshot.class));
  }
}

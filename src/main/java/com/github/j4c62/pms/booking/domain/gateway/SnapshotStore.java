package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.util.Optional;

public interface SnapshotStore {
  void saveSnapshot(BookingSnapshot snapshot);

  Optional<BookingSnapshot> getLatestSnapshot(BookingId bookingId);
}

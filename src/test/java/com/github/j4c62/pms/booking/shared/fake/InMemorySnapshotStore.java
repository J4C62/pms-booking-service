package com.github.j4c62.pms.booking.shared.fake;

import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySnapshotStore implements SnapshotStore {

  private final Map<BookingId, BookingSnapshot> store = new ConcurrentHashMap<>();

  @Override
  public void saveSnapshot(BookingSnapshot snapshot) {
    store.put(snapshot.bookingId(), snapshot);
  }

  @Override
  public Optional<BookingSnapshot> getLatestSnapshot(BookingId bookingId) {
    return Optional.ofNullable(store.get(bookingId));
  }
}

package com.github.j4c62.pms.booking.domain.aggregate.policy;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;

public class SnapshotPolicy {

  private static final int MAX_EVENTS_BEFORE_SNAPSHOT = 100;

  public boolean shouldCreateSnapshot(BookingAggregate aggregate) {

    return aggregate.bookingEvents().events().size() > MAX_EVENTS_BEFORE_SNAPSHOT;
  }
}

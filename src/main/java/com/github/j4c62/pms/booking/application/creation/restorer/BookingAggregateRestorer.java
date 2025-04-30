package com.github.j4c62.pms.booking.application.creation.restorer;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingAggregateRestorer {
  private final BookingAggregateMapper bookingAggregateMapper;

  public BookingAggregate restoreFromSnapshotAndEvents(
      BookingSnapshot snapshot, BookingEvents newEvents) {
    return newEvents.replayOn(bookingAggregateMapper.toAggregate(snapshot));
  }

  public BookingAggregate replay(@NonNull BookingEvents events) {
    return events.replayOn(null);
  }
}

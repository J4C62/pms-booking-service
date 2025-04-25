package com.github.j4c62.pms.booking.domain.aggregate.vo;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.util.List;
import java.util.stream.Stream;

public record BookingEvents(List<BookingEvent> events) {

  public BookingEvents {
    events = events == null ? List.of() : List.copyOf(events);
  }

  public BookingEvents append(BookingEvent event) {
    return new BookingEvents(Stream.concat(events.stream(), Stream.of(event)).toList());
  }

  public BookingAggregate replayOn(BookingAggregate base) {
    BookingAggregate result = base;
    for (BookingEvent event : events) {
      result = event.applyTo(result);
    }
    return result;
  }
}

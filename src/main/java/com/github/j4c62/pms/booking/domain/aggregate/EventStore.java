package com.github.j4c62.pms.booking.domain.aggregate;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.util.List;

public interface EventStore {
  void appendEvents(BookingId bookingId, List<BookingEvent> events);

  List<BookingEvent> getEventsForBooking(BookingId bookingId);
}

package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;

@FunctionalInterface
public interface BookingEventPublisher {
  void publish(BookingEvent bookingEvent);
}

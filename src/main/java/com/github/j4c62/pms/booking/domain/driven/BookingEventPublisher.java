package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;

public interface BookingEventPublisher {
  void publish(BookingEvent bookingEvent);
}

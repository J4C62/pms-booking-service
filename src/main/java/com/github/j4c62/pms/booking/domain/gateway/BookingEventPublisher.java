package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;

public interface BookingEventPublisher {
  void publish(BookingEvent bookingEvent);
}

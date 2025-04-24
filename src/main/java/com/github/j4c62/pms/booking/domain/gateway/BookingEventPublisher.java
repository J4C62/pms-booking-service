package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdatedEvent;

public interface BookingEventPublisher {
  void publishBookingCreated(BookingCreatedEvent bookingCreatedEvent);

  void publishBookingUpdated(BookingUpdatedEvent bookingUpdatedEvent);

  void publishBookingCancelled(BookingCancelledEvent bookingCancelledEvent);

  void publish(BookingEvent bookingEvent);
}

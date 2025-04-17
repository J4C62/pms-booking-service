package com.github.j4c62.pms.booking.domain.gateway;

import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;

public interface BookingEventPublisher {

  void publishBookingCreated(BookingCreated bookingCreated);

  void publishBookingUpdated(BookingUpdated bookingUpdated);

  void publishBookingCancelled(BookingCancelled bookingCancelled);
}

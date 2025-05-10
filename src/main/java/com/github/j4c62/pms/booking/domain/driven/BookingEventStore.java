package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

@FunctionalInterface
public interface BookingEventStore {
  BookingEvents getEventsForBooking(BookingId bookingId);
}

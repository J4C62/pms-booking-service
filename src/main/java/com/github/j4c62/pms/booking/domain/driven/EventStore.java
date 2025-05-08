package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public interface EventStore {
  BookingEvents getEventsForBooking(BookingId bookingId);
}

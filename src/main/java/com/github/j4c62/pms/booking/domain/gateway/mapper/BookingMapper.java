package com.github.j4c62.pms.booking.domain.gateway.mapper;

import com.github.j4c62.pms.booking.domain.model.Booking;

public interface BookingMapper<T> {

  T toEntity(Booking booking);

  Booking toRecord(T bookingEntity);
}

package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingEventMapper {

  BookingCreatedEvent toBookingCreated(Booking booking);

  BookingCancelledEvent toBookingCancelledEvent(CancelBookingInput cancelBookingInput);

}

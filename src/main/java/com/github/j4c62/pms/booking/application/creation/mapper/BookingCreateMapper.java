package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingCreateMapper {

  @Mapping(target = "bookingId", expression = "java(java.util.UUID.randomUUID())")
  @Mapping(target = "status", constant = "PENDING")
  Booking toBooking(CreateBookingInput createBookingInput);
}

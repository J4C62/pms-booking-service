package com.github.j4c62.pms.booking.application.creation.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingCreateMapper {

//  @Mapping(target = "bookingId", expression = "java(java.util.UUID.randomUUID())")
//  @Mapping(target = "status", constant = "PENDING")
//  BookingAggregate toBooking(CreateBookingInput createBookingInput);
}

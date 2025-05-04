package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingOutputMapper {

  BookingOutput toBookingOutput(BookingAggregate bookingAggregate);
}

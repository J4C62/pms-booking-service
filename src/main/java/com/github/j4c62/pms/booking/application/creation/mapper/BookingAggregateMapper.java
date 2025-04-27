package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface BookingAggregateMapper {

  @Mapping(target = "bookingId", expression = "java(new BookingId(UUID.randomUUID()))")
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "bookingEvents", ignore = true)
  @Mapping(target = "updateDates", ignore = true)
  BookingAggregate toAggregate(CreateBookingCommand input);
}

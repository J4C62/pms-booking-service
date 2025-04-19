package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;
import java.time.Instant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingEventMapper {

  BookingCreated toBookingCreated(Booking booking);

  @Mapping(source = "cancelBookingInput.bookingId", target = "bookingId")
  @Mapping(target = "cancelledAt", expression = "java(currentInstant())")
  BookingCancelled toBookingCancelled(Booking booking, CancelBookingInput cancelBookingInput);

  @Mapping(source = "updateBookingInput.bookingId", target = "bookingId")
  @Mapping(target = "updatedAt", expression = "java(currentInstant())")
  BookingUpdated toBookingUpdated(Booking booking, UpdateBookingInput updateBookingInput);

  default String currentInstant() {
    return Instant.now().toString();
  }
}

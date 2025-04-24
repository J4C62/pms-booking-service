package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import com.google.protobuf.ByteString;
import java.time.LocalDate;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingRequestMapper {

  @Mapping(
      target = "propertyId",
      expression = "java(mapPropertyId(byteStringToUUID(request.getPropertyId())))")
  @Mapping(
      target = "guestId",
      expression = "java(mapGuestId(byteStringToUUID(request.getGuestId())))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getStartDate(), request.getEndDate()))")
  CreateBookingInput toCreateInput(CreateBookingRequest request);

  @Mapping(target = "bookingId", expression = "java(mapBookingId(request.getBookingId()))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getNewStartDate(), request.getNewEndDate()))")
  UpdateBookingInput toUpdateInput(UpdateBookingRequest request);

  default UUID byteStringToUUID(ByteString value) {
    if (value == null || value.isEmpty()) throw new IllegalArgumentException("UUID cannot be null");
    return UUID.nameUUIDFromBytes(value.toByteArray());
  }

  default BookingId mapBookingId(ByteString id) {
    return new BookingId(byteStringToUUID(id));
  }

  default PropertyId mapPropertyId(UUID id) {
    return new PropertyId(id);
  }

  default GuestId mapGuestId(UUID id) {
    return new GuestId(id);
  }

  default LocalDate toLocalDate(String date) {
    if (date == null || date.isBlank()) {
      throw new IllegalArgumentException("Date string cannot be null or empty");
    }
    return LocalDate.parse(date);
  }

  default BookingDates mapBookingDates(String startDate, String endDate) {
    return new BookingDates(toLocalDate(startDate), toLocalDate(endDate));
  }

  default BookingDates mapBookingDates(LocalDate startDate, LocalDate endDate) {
    return new BookingDates(startDate, endDate);
  }
}

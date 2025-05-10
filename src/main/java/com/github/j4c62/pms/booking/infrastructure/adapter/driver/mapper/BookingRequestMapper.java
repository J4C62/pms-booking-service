package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.types.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import java.time.LocalDate;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingRequestMapper {

  @Mapping(target = "propertyId", expression = "java(mapPropertyId(request.getPropertyId()))")
  @Mapping(target = "guestId", expression = "java(mapGuestId(request.getGuestId()))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getStartDate(), request.getEndDate()))")
  CreateBookingCommand toCreateInput(CreateBookingRequest request);

  @Mapping(target = "bookingId", expression = "java(mapBookingId(request.getBookingId()))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getNewStartDate(), request.getNewEndDate()))")
  UpdateBookingDatesCommand toUpdateInput(UpdateBookingRequest request);

  @Mapping(target = "bookingId", expression = "java(mapBookingId(request.getBookingId()))")
  CancelBookingCommand toCancelInput(CancelBookingRequest request);

  default BookingId mapBookingId(String id) {
    return new BookingId(UUID.fromString(id));
  }

  default PropertyId mapPropertyId(String id) {
    return new PropertyId(UUID.fromString(id));
  }

  default GuestId mapGuestId(String id) {
    return new GuestId(UUID.fromString(id));
  }

  default LocalDate toLocalDate(String date) {
    return LocalDate.parse(date);
  }

  default BookingDates mapBookingDates(String startDate, String endDate) {
    return new BookingDates(toLocalDate(startDate), toLocalDate(endDate));
  }
}

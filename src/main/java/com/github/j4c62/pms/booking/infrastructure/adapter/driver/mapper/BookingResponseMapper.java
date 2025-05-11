package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookingResponseMapper {

  @Mapping(target = "bookingId", expression = "java(output.bookingId().value().toString())")
  BookingResponse toResponse(BookingOutput output);
}

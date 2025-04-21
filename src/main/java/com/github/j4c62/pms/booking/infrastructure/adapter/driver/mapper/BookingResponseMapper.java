package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingResponse;
import com.google.protobuf.ByteString;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookingResponseMapper {
  BookingResponse toResponse(BookingOutput output);

  default ByteString map(UUID value) {
    return ByteString.copyFrom(value.toString().getBytes(StandardCharsets.UTF_8));
  }
}

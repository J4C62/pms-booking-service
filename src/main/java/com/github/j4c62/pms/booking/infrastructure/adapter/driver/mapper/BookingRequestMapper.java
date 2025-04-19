package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookingRequestMapper {
  CreateBookingInput toCreateInput(CreateBookingRequest request);

  CancelBookingInput toCancelInput(CancelBookingRequest request);

  UpdateBookingInput toUpdateInput(UpdateBookingRequest request);
}

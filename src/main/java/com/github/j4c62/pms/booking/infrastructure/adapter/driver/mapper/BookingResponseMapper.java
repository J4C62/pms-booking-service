package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper interface for converting domain-level {@link BookingOutput} objects into gRPC {@code
 * BookingResponse} messages.
 *
 * <p>This mapper is used by the {@link
 * com.github.j4c62.pms.booking.infrastructure.adapter.driver.GrpcControllerAdapter} to translate
 * the result of command executions into the appropriate gRPC response payloads.
 *
 * <p>Implemented automatically by MapStruct. Any unmapped properties on either source or target are
 * ignored to allow forward compatibility.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-18
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface BookingResponseMapper {

  /**
   * Converts a {@link BookingOutput} into a gRPC {@code BookingResponse}.
   *
   * @param output the domain output object
   * @return the gRPC-compatible response
   * @author Jose Antonio (J4c62)
   * @since 2025-04-18
   */
  @Mapping(target = "bookingId", expression = "java(output.bookingId().value().toString())")
  @Mapping(target = "status", expression = "java(output.status().name())")
  @Mapping(target = "mergeFrom", ignore = true)
  @Mapping(target = "clearExtension", ignore = true)
  @Mapping(target = "clearField", ignore = true)
  @Mapping(target = "clearOneof", ignore = true)
  @Mapping(target = "bookingIdBytes", ignore = true)
  @Mapping(target = "statusBytes", ignore = true)
  @Mapping(target = "unknownFields", ignore = true)
  @Mapping(target = "mergeUnknownFields", ignore = true)
  @Mapping(target = "allFields", ignore = true)
  BookingResponse toResponse(BookingOutput output);
}

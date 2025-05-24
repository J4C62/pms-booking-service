package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import static java.time.format.DateTimeFormatter.ofPattern;

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
import java.time.format.DateTimeParseException;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting incoming gRPC booking requests into domain-level command objects.
 *
 * <p>Used by {@link
 * com.github.j4c62.pms.booking.infrastructure.adapter.driver.GrpcControllerAdapter} to map incoming
 * Protobuf messages into {@code CreateBookingCommand}, {@code CancelBookingCommand}, and {@code
 * UpdateBookingDatesCommand}, which are handled by the core domain layer.
 *
 * <p>This interface is implemented automatically by MapStruct. It also includes custom mapping
 * logic for domain value objects such as {@link BookingId}, {@link PropertyId}, {@link GuestId},
 * and {@link BookingDates}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-18
 */
@Mapper(componentModel = "spring")
public interface BookingRequestMapper {
  /**
   * Maps a gRPC {@code CreateBookingRequest} to a {@code CreateBookingCommand}.
   *
   * @param request the incoming gRPC request
   * @return a domain command representing the creation request
   * @author Jose Antonio (J4c62)
   * @since 2025-04-19
   */
  @Mapping(target = "propertyId", expression = "java(mapPropertyId(request.getPropertyId()))")
  @Mapping(target = "guestId", expression = "java(mapGuestId(request.getGuestId()))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getStartDate(), request.getEndDate()))")
  CreateBookingCommand toCreateInput(CreateBookingRequest request);

  /**
   * Maps a gRPC {@code UpdateBookingRequest} to an {@code UpdateBookingDatesCommand}.
   *
   * @param request the incoming gRPC update request
   * @return a domain command representing the update
   * @author Jose Antonio (J4c62)
   * @since 2025-04-19
   */
  @Mapping(target = "bookingId", expression = "java(mapBookingId(request.getBookingId()))")
  @Mapping(
      target = "bookingDates",
      expression = "java(mapBookingDates(request.getNewStartDate(), request.getNewEndDate()))")
  UpdateBookingDatesCommand toUpdateInput(UpdateBookingRequest request);

  /**
   * Maps a gRPC {@code CancelBookingRequest} to a {@code CancelBookingCommand}.
   *
   * @param request the incoming cancellation request
   * @return a domain command representing the cancellation
   * @author Jose Antonio (J4c62)
   * @since 2025-04-19
   */
  @Mapping(target = "bookingId", expression = "java(mapBookingId(request.getBookingId()))")
  CancelBookingCommand toCancelInput(CancelBookingRequest request);

  /**
   * Converts a string UUID to a {@link BookingId}.
   *
   * @param id the UUID string
   * @return a strongly typed BookingId
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  default BookingId mapBookingId(String id) {
    if (id.isEmpty()) {
      throw new IllegalArgumentException(
          "booking_id:'%s' invalid, valid format UUID".formatted(id));
    }
    return BookingId.of(UUID.fromString(id));
  }

  /**
   * Converts a string UUID to a {@link PropertyId}.
   *
   * @param id the UUID string
   * @return a strongly typed PropertyId
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  default PropertyId mapPropertyId(String id) {
    if (id.isEmpty()) {
      throw new IllegalArgumentException(
          "property_id:'%s' invalid, valid format UUID".formatted(id));
    }
    return PropertyId.of(UUID.fromString(id));
  }

  /**
   * Converts a string UUID to a {@link GuestId}.
   *
   * @param id the UUID string
   * @return a strongly typed GuestId
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  default GuestId mapGuestId(String id) {
    if (id.isEmpty()) {
      throw new IllegalArgumentException("guest_id:'%s' invalid, valid format UUID".formatted(id));
    }

    return GuestId.of(UUID.fromString(id));
  }

  /**
   * Parses a {@link LocalDate} from a string.
   *
   * @param date the ISO-8601 formatted date string
   * @return a {@code LocalDate} instance
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  default LocalDate toLocalDate(String date) {
    try {
      return LocalDate.parse(date, ofPattern("yyyy-MM-dd"));
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException(
          "Invalid date format: expected yyyy-MM-dd, got '%s'".formatted(date), e);
    }
  }

  /**
   * Creates a {@link BookingDates} value object from string inputs.
   *
   * @param startDate start date in ISO-8601 format
   * @param endDate end date in ISO-8601 format
   * @return the {@code BookingDates} value object
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  default BookingDates mapBookingDates(String startDate, String endDate) {
    return BookingDates.of(toLocalDate(startDate), toLocalDate(endDate));
  }
}

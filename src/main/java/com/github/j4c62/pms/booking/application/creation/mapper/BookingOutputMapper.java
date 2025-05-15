package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import org.mapstruct.Mapper;

/**
 * MapStruct mapper interface for converting a {@link BookingAggregate} to a {@link BookingOutput}
 * DTO.
 *
 * <p>This mapper is used to transform the internal domain representation of a booking into a format
 * suitable for external layers such as APIs, UIs, or external systems.
 *
 * <p>It is integrated with Spring's dependency injection via {@code componentModel = "spring"}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-30
 */
@Mapper(componentModel = "spring")
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface BookingOutputMapper {
  /**
   * Maps a {@link BookingAggregate} to a {@link BookingOutput} DTO.
   *
   * @param bookingAggregate The domain aggregate representing the booking state.
   * @return A data transfer object suitable for presentation or external interfaces.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  BookingOutput toBookingOutput(BookingAggregate bookingAggregate);
}

package com.github.j4c62.pms.booking.application.creation.mapper;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.types.CreateBookingCommand;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper interface for converting input commands into domain aggregates.
 *
 * <p>This mapper transforms a {@link CreateBookingCommand} into a {@link BookingAggregate},
 * initializing only the essential fields for the creation of a new booking. Non-mapped fields such
 * as status and bookingEvents are handled elsewhere in the domain logic.
 *
 * <p>The {@code bookingId} is generated automatically as a new {@link
 * com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId} wrapping a random UUID.
 *
 * <p>This mapper uses Spring's dependency injection framework.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-24
 */
@Mapper(
    componentModel = "spring",
    imports = {UUID.class, List.class})
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface BookingAggregateMapper {
  /**
   * Maps a {@link CreateBookingCommand} to a {@link BookingAggregate}.
   *
   * <ul>
   *   <li>Generates a new {@code BookingId} using a random UUID.
   *   <li>Ignores {@code status}, {@code bookingEvents}, and {@code updateDates} — those are set
   *       later in domain logic.
   * </ul>
   *
   * @param input The booking creation command.
   * @return A partially initialized {@code BookingAggregate} with values from the command.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  @Mapping(target = "bookingId", expression = "java(new BookingId(UUID.randomUUID()))")
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "bookingEvents", ignore = true)
  @Mapping(target = "updateDates", ignore = true)
  BookingAggregate toAggregate(CreateBookingCommand input);
}

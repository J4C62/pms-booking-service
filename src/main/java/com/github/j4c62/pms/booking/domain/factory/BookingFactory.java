package com.github.j4c62.pms.booking.domain.factory;

import static com.github.j4c62.pms.booking.domain.builder.BookingBuilder.builder;
import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.*;
import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.domain.shared.validator.Validator;
import java.util.List;
import java.util.UUID;

public class BookingFactory {

  public static BookingFactory createBookingFactory() {
    return new BookingFactory();
  }

  public Booking create(CreateBookingCommand command) {
    validateBookingCommand(command);
    return buildBooking(command);
  }

  private void validateBookingCommand(CreateBookingCommand command) {
    validateNonNullFields(command);
    validateBookingRules(command);
  }

  private void validateNonNullFields(CreateBookingCommand command) {
    requireNonNull(command.propertyId(), "Property ID cannot be null");
    requireNonNull(command.guestId(), "Guest ID cannot be null");
    requireNonNull(command.startDate(), "Start Date cannot be null");
    requireNonNull(command.endDate(), "End Date cannot be null");
  }

  private void validateBookingRules(CreateBookingCommand command) {
    List<Validator> validators =
        List.of(
            () -> requireNotBlank(command.propertyId(), "Property ID"),
            () -> requireNotBlank(command.guestId(), "Guest ID"),
            () -> requireValidDate(command.startDate(), "Start date"),
            () -> requireValidDate(command.endDate(), "End date"),
            () -> requireStartBeforeEnd(command.startDate(), command.endDate()),
            () -> requireStartNotInPast(command.endDate()));
    validators.forEach(Validator::validate);
  }

  private Booking buildBooking(CreateBookingCommand command) {
    return builder()
        .bookingId(UUID.randomUUID().toString())
        .propertyId(command.propertyId())
        .guestId(command.guestId())
        .startDate(command.startDate())
        .endDate(command.endDate())
        .status(BookingStatus.PENDING)
        .build();
  }
}

package com.github.j4c62.pms.booking.application.creation.factory;

import static com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder.builder;
import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.*;
import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.domain.shared.validator.Validator;
import java.util.List;
import java.util.UUID;

public class BookingFactory {

  public static BookingFactory createBookingFactory() {
    return new BookingFactory();
  }

  public Booking create(CreateBookingInput createBookingInput) {
    validateBookingCommand(createBookingInput);
    return buildBooking(createBookingInput);
  }

  private void validateBookingCommand(CreateBookingInput createBookingInput) {
    validateNonNullFields(createBookingInput);
    validateBookingRules(createBookingInput);
  }

  private void validateNonNullFields(CreateBookingInput createBookingInput) {
    requireNonNull(createBookingInput.getPropertyId(), "Property ID cannot be null");
    requireNonNull(createBookingInput.getGuestId(), "Guest ID cannot be null");
    requireNonNull(createBookingInput.getStartDate(), "Start Date cannot be null");
    requireNonNull(createBookingInput.getEndDate(), "End Date cannot be null");
  }

  private void validateBookingRules(CreateBookingInput createBookingInput) {
    List<Validator> validators =
        List.of(
            () -> requireNotBlank(createBookingInput.getPropertyId(), "Property ID"),
            () -> requireNotBlank(createBookingInput.getGuestId(), "Guest ID"),
            () -> requireValidDate(createBookingInput.getStartDate(), "Start date"),
            () -> requireValidDate(createBookingInput.getEndDate(), "End date"),
            () ->
                requireStartBeforeEnd(
                    createBookingInput.getStartDate(), createBookingInput.getEndDate()),
            () -> requireStartNotInPast(createBookingInput.getEndDate()));
    validators.forEach(Validator::validate);
  }

  private Booking buildBooking(CreateBookingInput createBookingInput) {
    return builder()
        .bookingId(UUID.randomUUID().toString())
        .propertyId(createBookingInput.getPropertyId())
        .guestId(createBookingInput.getGuestId())
        .startDate(createBookingInput.getStartDate())
        .endDate(createBookingInput.getEndDate())
        .status(BookingStatus.PENDING)
        .build();
  }
}

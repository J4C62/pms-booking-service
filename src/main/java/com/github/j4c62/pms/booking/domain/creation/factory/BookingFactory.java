package com.github.j4c62.pms.booking.domain.creation.factory;

import static com.github.j4c62.pms.booking.domain.creation.builder.BookingBuilder.builder;
import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.*;
import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.domain.driver.request.CreateBookingRequest;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.domain.shared.validator.Validator;
import java.util.List;
import java.util.UUID;

public class BookingFactory {

  public static BookingFactory createBookingFactory() {
    return new BookingFactory();
  }

  public Booking create(CreateBookingRequest createBookingRequest) {
    validateBookingCommand(createBookingRequest);
    return buildBooking(createBookingRequest);
  }

  private void validateBookingCommand(CreateBookingRequest createBookingRequest) {
    validateNonNullFields(createBookingRequest);
    validateBookingRules(createBookingRequest);
  }

  private void validateNonNullFields(CreateBookingRequest createBookingRequest) {
    requireNonNull(createBookingRequest.propertyId(), "Property ID cannot be null");
    requireNonNull(createBookingRequest.guestId(), "Guest ID cannot be null");
    requireNonNull(createBookingRequest.startDate(), "Start Date cannot be null");
    requireNonNull(createBookingRequest.endDate(), "End Date cannot be null");
  }

  private void validateBookingRules(CreateBookingRequest createBookingRequest) {
    List<Validator> validators =
        List.of(
            () -> requireNotBlank(createBookingRequest.propertyId(), "Property ID"),
            () -> requireNotBlank(createBookingRequest.guestId(), "Guest ID"),
            () -> requireValidDate(createBookingRequest.startDate(), "Start date"),
            () -> requireValidDate(createBookingRequest.endDate(), "End date"),
            () ->
                requireStartBeforeEnd(
                    createBookingRequest.startDate(), createBookingRequest.endDate()),
            () -> requireStartNotInPast(createBookingRequest.endDate()));
    validators.forEach(Validator::validate);
  }

  private Booking buildBooking(CreateBookingRequest createBookingRequest) {
    return builder()
        .bookingId(UUID.randomUUID().toString())
        .propertyId(createBookingRequest.propertyId())
        .guestId(createBookingRequest.guestId())
        .startDate(createBookingRequest.startDate())
        .endDate(createBookingRequest.endDate())
        .status(BookingStatus.PENDING)
        .build();
  }
}

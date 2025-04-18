package com.github.j4c62.pms.booking.application.creation.factory;

import static com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder.builder;

import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class BookingAssembler {

  public Booking toBooking(CreateBookingInput createBookingInput) {
    return assembled(createBookingInput);
  }

  private Booking assembled(CreateBookingInput createBookingInput) {
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

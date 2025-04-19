package com.github.j4c62.pms.booking.shared;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import java.util.UUID;

public class BookingTestFactory {

  public static BookingEntity createBookingEntity(UUID bookingId, String status) {
    return BookingEntity.builder()
        .bookingId(bookingId)
        .status(BookingStatus.valueOf(status))
        .startDate("2025-04-20")
        .endDate("2025-04-21")
        .guestId("guest1")
        .propertyId("property1")
        .build();
  }

  public static Booking createBooking(UUID bookingId, String status) {
    return new Booking(
        bookingId,
        UUID.randomUUID(),
        "guest1",
        "2025-04-20",
        "2025-04-21",
        BookingStatus.valueOf(status));
  }

  public static BookingEntity createDefaultBookingEntity(UUID bookingId) {
    return createBookingEntity(bookingId, "PENDING");
  }

  public static Booking createDefaultBooking(UUID bookingId) {
    return createBooking(bookingId, "PENDING");
  }
}

package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractBookingCommandHandler {
  protected final BookingRepository bookingRepository;
  protected final BookingEventPublisher eventPublisher;
  protected final BookingEventMapper eventMapper;

  protected void assertAffectedRows(UUID bookingId, int affectedRows, String operation) {
    if (affectedRows == 0) {
      throw new IllegalArgumentException(
          "Booking with ID " + bookingId + " could not be " + operation + ".");
    }
  }
}

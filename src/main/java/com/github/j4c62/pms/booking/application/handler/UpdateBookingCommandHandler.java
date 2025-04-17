package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.request.UpdateBookingRequest;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookingCommandHandler implements BookingUpdater {
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;
  private final BookingEventFactory eventFactory;

  @Override
  public Booking update(UpdateBookingRequest updateBookingRequest) {
    var existing =
        bookingRepository
            .findById(updateBookingRequest.bookingId())
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

    existing.validateUpdatable(
        updateBookingRequest.newStartDate(), updateBookingRequest.newEndDate());

    var updated =
        existing.updateDates(
            updateBookingRequest.newStartDate(), updateBookingRequest.newEndDate());
    var saved = bookingRepository.save(updated);

    eventPublisher.publishBookingUpdated(
        eventFactory.createBookingUpdated(saved, updateBookingRequest));

    return saved;
  }
}

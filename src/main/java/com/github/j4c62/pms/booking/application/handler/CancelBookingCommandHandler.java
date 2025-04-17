package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.request.CancelBookingRequest;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelBookingCommandHandler implements BookingCanceller {
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;
  private final BookingEventFactory eventFactory;

  @Override
  public Booking cancel(CancelBookingRequest cancelBookingRequest) {
    var existing = getBooking(cancelBookingRequest);
    existing.validateCancellable();
    var cancelled = existing.cancel();
    var saved = bookingRepository.save(cancelled);
    eventPublisher.publishBookingCancelled(
        eventFactory.createBookingCancelled(saved, cancelBookingRequest));
    return saved;
  }

  private Booking getBooking(CancelBookingRequest cancelBookingRequest) {
    return bookingRepository
        .findById(cancelBookingRequest.bookingId())
        .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
  }
}

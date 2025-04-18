package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
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
  public BookingOutput cancel(CancelBookingInput cancelBookingInput) {
    var existing = getBooking(cancelBookingInput);
    existing.validateCancellable();
    var cancelled = existing.cancel();
    var saved = bookingRepository.save(cancelled);
    eventPublisher.publishBookingCancelled(
        eventFactory.createBookingCancelled(saved, cancelBookingInput));
    return new BookingOutput(saved.bookingId(), saved.status());
  }

  private Booking getBooking(CancelBookingInput cancelBookingInput) {
    return bookingRepository
        .findById(cancelBookingInput.getBookingId())
        .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
  }
}

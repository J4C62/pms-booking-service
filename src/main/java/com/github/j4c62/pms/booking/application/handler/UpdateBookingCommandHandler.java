package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookingCommandHandler implements BookingUpdater {
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;
  private final BookingEventMapper eventFactory;

  @Override
  public BookingOutput update(UpdateBookingInput updateBookingInput) {
    var existing =
        bookingRepository
            .findById(updateBookingInput.getBookingId())
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

    existing.validateUpdatable(
        updateBookingInput.getNewStartDate(), updateBookingInput.getNewEndDate());

    var updated =
        existing.updateDates(
            updateBookingInput.getNewStartDate(), updateBookingInput.getNewEndDate());
    var saved = bookingRepository.save(updated);

    eventPublisher.publishBookingUpdated(eventFactory.toBookingUpdated(saved, updateBookingInput));

    return new BookingOutput(saved.bookingId(), saved.status());
  }
}

package com.github.j4c62.pms.booking.application.service;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.dto.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.repository.BookingRepository;
import com.github.j4c62.pms.booking.infrastructure.kafka.BookingEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher bookingEventPublisher;
  private final BookingFactory bookingFactory = BookingFactory.createBookingFactory();
  private final BookingEventFactory eventFactory = BookingEventFactory.createBookingFactory();

  public Booking createBooking(CreateBookingCommand command) {
    return processPendingBooking(processNewBooking(command));
  }

  public Booking updateBooking(String bookingId, UpdateBookingCommand updateCommand) {
    var existingBooking = findBookingOrThrow(bookingId);
    return processExistingBooking(existingBooking, updateCommand);
  }

  public Booking cancelBooking(String bookingId) {
    var existingBooking = findBookingOrThrow(bookingId);
    return processExistingBooking(existingBooking.cancel(), null);
  }

  private Booking processExistingBooking(Booking booking, UpdateBookingCommand updateCommand) {
    return switch (booking.status()) {
      case PENDING -> processPendingBooking(booking);
      case CONFIRMED -> processConfirmedBooking(booking, updateCommand);
      case CANCELLED -> save(booking);
    };
  }

  private Booking processPendingBooking(Booking booking) {
    var saved = save(booking);
    bookingEventPublisher.publishBookingCreated(eventFactory.createBookingCreate(saved));
    return saved;
  }

  private Booking processConfirmedBooking(Booking booking, UpdateBookingCommand updateCommand) {
    var updatedBooking =
        save(booking.updateDates(updateCommand.newStartDate(), updateCommand.newEndDate()));
    bookingEventPublisher.publishBookingUpdated(
        eventFactory.createBookingUpdated(booking, updateCommand));
    return updatedBooking;
  }

  private Booking processNewBooking(CreateBookingCommand createCommand) {
    return bookingFactory.create(createCommand);
  }

  private Booking findBookingOrThrow(String bookingId) {
    return bookingRepository
        .findById(bookingId)
        .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + bookingId));
  }

  private Booking save(Booking booking) {
    return bookingRepository.save(booking);
  }
}

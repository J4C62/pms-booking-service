package com.github.j4c62.pms.booking.application.service;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.dto.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.repository.BookingRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

  private final BookingRepository bookingRepository;
  private final BookingFactory bookingFactory;

  public Booking createBooking(CreateBookingCommand command) {
    return bookingRepository.save(
        bookingFactory.create(
            UUID.randomUUID().toString(),
            command.propertyId(),
            command.guestId(),
            command.startDate(),
            command.endDate(),
            null));
  }

  public Booking cancelBooking(String bookingId) {
    return bookingRepository.save(
        bookingRepository
            .findById(bookingId)
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"))
            .cancel());
  }

  public Booking updateBooking(String bookingId, UpdateBookingCommand updatedCommand) {
    return bookingRepository
        .findById(bookingId)
        .orElseThrow(() -> new IllegalArgumentException("Booking not found"))
        .updateDates(updatedCommand.startDate(), updatedCommand.endDate());
  }
}

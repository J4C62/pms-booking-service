package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.assembler.BookingCreateMapper;
import com.github.j4c62.pms.booking.application.creation.assembler.BookingEventAssembler;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingCommandHandler implements BookingCreator {
  private final BookingCreateMapper bookingCreateMapper;
  private final BookingEventAssembler bookingEventAssembler;
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;

  @Transactional
  @Override
  public BookingOutput create(CreateBookingInput createBookingInput) {
    var booking = bookingCreateMapper.toBooking(createBookingInput);
    var saved = bookingRepository.save(booking);
    var bookingCreated = bookingEventAssembler.toBookingCreated(saved);
    eventPublisher.publishBookingCreated(bookingCreated);
    return new BookingOutput(saved.bookingId(), saved.status());
  }
}

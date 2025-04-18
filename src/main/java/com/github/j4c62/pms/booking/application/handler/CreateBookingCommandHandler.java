package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.application.creation.factory.BookingFactory;
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
  private final BookingFactory bookingFactory;
  private final BookingEventFactory bookingEventFactory;
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;

  @Transactional
  @Override
  public BookingOutput create(CreateBookingInput createBookingInput) {
    var booking = bookingFactory.create(createBookingInput);
    var saved = bookingRepository.save(booking);
    var bookingCreated = bookingEventFactory.createBookingCreated(saved);
    eventPublisher.publishBookingCreated(bookingCreated);
    return new BookingOutput(saved.bookingId(), saved.status());
  }
}

package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.request.CreateBookingRequest;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingCommandHandler implements BookingCreator {
  private final BookingFactory bookingFactory;
  private final BookingEventFactory bookingEventFactory;
  private final BookingRepository bookingRepository;
  private final BookingEventPublisher eventPublisher;

  @Override
  public Booking create(CreateBookingRequest createBookingRequest) {
    var booking = bookingFactory.create(createBookingRequest);
    var saved = bookingRepository.save(booking);
    var bookingCreated = bookingEventFactory.createBookingCreated(saved);
    eventPublisher.publishBookingCreated(bookingCreated);
    return saved;
  }
}

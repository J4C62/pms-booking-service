package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.model.Booking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateBookingCommandHandlerTest {

  @Mock private BookingFactory bookingFactory;
  @Mock private BookingEventFactory bookingEventFactory;
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;

  @InjectMocks private CreateBookingCommandHandler handler;

  @Test
  @DisplayName("Should create a booking and publish BookingCreated event")
  void shouldCreateBookingSuccessfully() {
    var request = new CreateBookingCommand("p123", "g456", "2025-07-01", "2025-07-10");
    var booking = mock(Booking.class);
    var savedBooking = mock(Booking.class);
    var bookingCreatedEvent = mock(BookingCreated.class);

    when(bookingFactory.create(request)).thenReturn(booking);
    when(bookingRepository.save(booking)).thenReturn(savedBooking);
    when(bookingEventFactory.createBookingCreated(savedBooking)).thenReturn(bookingCreatedEvent);

    var result = handler.create(request);

    verify(bookingFactory).create(request);
    verify(bookingRepository).save(booking);
    verify(eventPublisher).publishBookingCreated(bookingCreatedEvent);
    assertThat(result).isEqualTo(savedBooking);
  }
}

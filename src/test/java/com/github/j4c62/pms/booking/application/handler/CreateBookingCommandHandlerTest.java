package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.creation.assembler.BookingCreateMapper;
import com.github.j4c62.pms.booking.application.creation.assembler.BookingEventAssembler;
import com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateBookingCommandHandlerTest {

  @Mock private BookingCreateMapper bookingCreateMapper;
  @Mock private BookingEventAssembler bookingEventAssembler;
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;

  @InjectMocks private CreateBookingCommandHandler handler;

  @Test
  @DisplayName("Should create a booking and publish BookingCreated event")
  void shouldCreateBookingSuccessfully() {

    var request = new CreateBookingCommand("p123", "g456", "2025-07-01", "2025-07-10");
    var booking =
        BookingBuilder.builder()
            .bookingId("b123")
            .propertyId("123")
            .guestId("guest11")
            .startDate("2025-05-01")
            .endDate("2025-06-01")
            .build();
    var bookingCreatedEvent = new BookingCreated("b123", "prop-123", "guest-123", "", "");
    var bookingOutput = new BookingOutput(booking.bookingId(), BookingStatus.PENDING);

    when(bookingCreateMapper.toBooking(request)).thenReturn(booking);
    when(bookingRepository.save(booking)).thenReturn(booking);
    when(bookingEventAssembler.toBookingCreated(booking)).thenReturn(bookingCreatedEvent);

    var result = handler.create(request);

    verify(bookingCreateMapper).toBooking(request);
    verify(bookingRepository).save(booking);
    verify(eventPublisher).publishBookingCreated(bookingCreatedEvent);
    assertThat(result).isEqualTo(bookingOutput);
  }
}

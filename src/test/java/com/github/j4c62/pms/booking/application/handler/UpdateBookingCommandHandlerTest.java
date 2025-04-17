package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateBookingCommandHandlerTest {

  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @Mock private BookingEventFactory eventFactory;

  @InjectMocks private UpdateBookingCommandHandler handler;

  @Test
  @DisplayName("Should update booking and publish BookingUpdated event")
  void shouldUpdateBookingSuccessfully() {
    var request =
        new UpdateBookingCommand("b123", "2025-08-01", "2025-08-10", "Guest change plans");
    var existing = mock(Booking.class);
    var updated = mock(Booking.class);
    var saved = mock(Booking.class);
    var event = mock(BookingUpdated.class);

    when(bookingRepository.findById("b123")).thenReturn(Optional.of(existing));
    when(existing.updateDates("2025-08-01", "2025-08-10")).thenReturn(updated);
    when(bookingRepository.save(updated)).thenReturn(saved);
    when(eventFactory.createBookingUpdated(saved, request)).thenReturn(event);

    var result = handler.update(request);

    verify(existing).validateUpdatable("2025-08-01", "2025-08-10");
    verify(existing).updateDates("2025-08-01", "2025-08-10");
    verify(bookingRepository).save(updated);
    verify(eventPublisher).publishBookingUpdated(event);
    assertThat(result).isEqualTo(saved);
  }

  @Test
  @DisplayName("Should throw if booking is not found")
  void shouldThrowIfBookingNotFound() {
    var request =
        new UpdateBookingCommand("not_found", "2025-09-01", "2025-09-10", "Guest change plans");
    when(bookingRepository.findById("not_found")).thenReturn(Optional.empty());

    assertThatThrownBy(() -> handler.update(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Booking not found");
  }
}

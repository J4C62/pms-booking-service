package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.application.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CancelBookingCommandHandlerTest {

  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @Mock private BookingEventFactory eventFactory;

  @InjectMocks private CancelBookingCommandHandler handler;

  @Test
  @DisplayName("Should cancel a booking and publish BookingCancelled event")
  void shouldCancelBookingSuccessfully() {
    var request = new CancelBookingCommand("b123", "guest-1", "Changed plans", "2025-06-01");
    var existingBooking = BookingBuilder.builder().bookingId("b123").build();
    var cancelledBooking = existingBooking.cancel();
    var fakeOutput = new BookingOutput("b123", BookingStatus.CANCELLED);
    var bookingCancelledEvent =
        BookingEventFactory.createBookingFactory()
            .createBookingCancelled(cancelledBooking, request);

    when(bookingRepository.findById("b123")).thenReturn(Optional.of(existingBooking));
    when(bookingRepository.save(cancelledBooking)).thenReturn(cancelledBooking);
    when(eventFactory.createBookingCancelled(cancelledBooking, request))
        .thenReturn(bookingCancelledEvent);

    var result = handler.cancel(request);

    verify(bookingRepository).findById("b123");
    verify(bookingRepository).save(cancelledBooking);
    verify(eventPublisher).publishBookingCancelled(bookingCancelledEvent);
    assertThat(result).isEqualTo(fakeOutput);
  }

  @Test
  @DisplayName("Should throw exception when booking is not found")
  void shouldThrowIfBookingNotFound() {
    var request = new CancelBookingCommand("not-found-id", "guest", "reason", "2025-05-01");

    when(bookingRepository.findById("not-found-id")).thenReturn(Optional.empty());

    assertThatThrownBy(() -> handler.cancel(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Booking not found");

    verifyNoInteractions(eventPublisher, eventFactory);
  }
}

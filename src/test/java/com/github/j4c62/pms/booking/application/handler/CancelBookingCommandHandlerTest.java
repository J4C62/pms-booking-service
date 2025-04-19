package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName(
    "Unit tests for CancelBookingCommandHandler - Verifying cancel logic and event publishing")
class CancelBookingCommandHandlerTest {

  private static final UUID BOOKING_ID = UUID.randomUUID();
  private static final String CANCELLED_BY = "guest-1";
  private static final String REASON = "Changed plans";
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @Mock private BookingEventMapper bookingEventMapper;
  @InjectMocks private CancelBookingCommandHandler handler;

  @Test
  @DisplayName("Given valid input when cancelling booking then should cancel and publish event")
  void givenValidInputWhenCancellingBookingThenShouldCancelAndPublishEvent() {
    CancelBookingInput input = new CancelBookingCommand(BOOKING_ID, CANCELLED_BY, REASON);

    when(bookingRepository.updateCanceledBooking(BOOKING_ID)).thenReturn(1);
    when(bookingEventMapper.toBookingCancelledEvent(input))
        .thenReturn(new BookingCancelledEvent(BOOKING_ID, CANCELLED_BY, REASON, "2025-04-19"));

    var result = handler.cancel(input);

    assertThat(result).isNotNull();
    assertThat(result.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(result.status()).isEqualTo(BookingStatus.CANCELLED);

    verify(bookingRepository).updateCanceledBooking(BOOKING_ID);
    verify(eventPublisher).publishBookingCancelled(any(BookingCancelledEvent.class));
  }

  @Test
  @DisplayName(
      "Given non-existing booking when cancelling then should throw IllegalArgumentException")
  void givenNonExistingBookingWhenCancellingThenShouldThrowIllegalStateException() {
    CancelBookingInput input = new CancelBookingCommand(BOOKING_ID, CANCELLED_BY, REASON);

    when(bookingRepository.updateCanceledBooking(BOOKING_ID)).thenReturn(0);

    assertThatThrownBy(() -> handler.cancel(input))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Booking with ID " + BOOKING_ID + " could not be cancelled");

    verify(bookingRepository).updateCanceledBooking(BOOKING_ID);
    verifyNoInteractions(eventPublisher);
  }
}

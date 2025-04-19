package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdatedEvent;
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
    "Unit tests for UpdateBookingCommandHandler - Verifying update logic and event publishing")
class UpdateBookingCommandHandlerTest {

  private static final UUID BOOKING_ID = UUID.randomUUID();
  private static final String NEW_START_DATE = "2025-06-01";
  private static final String NEW_END_DATE = "2025-06-10";
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @Mock private BookingEventMapper eventFactory;
  @InjectMocks private UpdateBookingCommandHandler handler;

  @Test
  @DisplayName("Given valid input when updating booking then should update and publish event")
  void givenValidInputWhenUpdatingBookingThenShouldUpdateAndPublishEvent() {
    UpdateBookingInput input = new UpdateBookingInput();
    input.setBookingId(BOOKING_ID);
    input.setNewStartDate(NEW_START_DATE);
    input.setNewEndDate(NEW_END_DATE);

    when(bookingRepository.updateBookingDates(BOOKING_ID, NEW_START_DATE, NEW_END_DATE))
        .thenReturn(1);

    when(eventFactory.toBookingUpdated(input))
        .thenReturn(
            new BookingUpdatedEvent(
                BOOKING_ID, "oldStart", "oldEnd", NEW_START_DATE, NEW_END_DATE));

    BookingOutput result = handler.update(input);

    assertThat(result).isNotNull();
    assertThat(result.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(result.status()).isEqualTo(BookingStatus.PENDING);

    verify(bookingRepository).updateBookingDates(BOOKING_ID, NEW_START_DATE, NEW_END_DATE);
    verify(eventPublisher).publishBookingUpdated(any(BookingUpdatedEvent.class));
  }

  @Test
  @DisplayName(
      "Given non-existing booking when updating then should throw IllegalArgumentException")
  void givenNonExistingBookingWhenUpdatingThenShouldThrowIllegalStateException() {
    UpdateBookingInput input = new UpdateBookingInput();
    input.setBookingId(BOOKING_ID);
    input.setNewStartDate("2024-05-01");
    input.setNewEndDate("2024-05-02");
    input.setUpdateReason("");
    when(bookingRepository.updateBookingDates(any(), any(), any())).thenReturn(0);

    assertThatThrownBy(() -> handler.update(input))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Booking with ID " + BOOKING_ID + " could not be updated.");

    verify(bookingRepository).updateBookingDates(any(), any(), any());
    verifyNoInteractions(eventPublisher);
  }
}

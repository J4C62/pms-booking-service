package com.github.j4c62.pms.booking.application.handler;

import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
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
  @Mock private BookingEventPublisher eventPublisher;
  @InjectMocks private UpdateBookingCommandHandler handler;

  @Test
  @DisplayName("Given valid input when updating booking then should update and publish event")
  void givenValidInputWhenUpdatingBookingThenShouldUpdateAndPublishEvent() {}

  @Test
  @DisplayName(
      "Given non-existing booking when updating then should throw IllegalArgumentException")
  void givenNonExistingBookingWhenUpdatingThenShouldThrowIllegalStateException() {}
}

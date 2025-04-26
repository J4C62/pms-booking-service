package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
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
    "Unit tests for CancelBookingCommandHandler - Verifying cancel logic and event publishing")
class CancelBookingCommandHandlerTest {

  private static final UUID BOOKING_ID = UUID.randomUUID();
  private static final String CANCELLED_BY = "guest-1";
  private static final String REASON = "Changed plans";
  @Mock private BookingEventPublisher eventPublisher;
  @InjectMocks private CancelBookingCommandHandler handler;

  @Test
  @DisplayName("Given valid input when cancelling booking then should cancel and publish event")
  void givenValidInputWhenCancellingBookingThenShouldCancelAndPublishEvent() {}

  @Test
  @DisplayName(
      "Given non-existing booking when cancelling then should throw IllegalArgumentException")
  void givenNonExistingBookingWhenCancellingThenShouldThrowIllegalStateException() {}
}

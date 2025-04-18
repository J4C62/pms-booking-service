package com.github.j4c62.pms.booking.domain.creation.factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.domain.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingEventFactoryTest {

  private final BookingEventFactory factory = BookingEventFactory.createBookingFactory();

  @Mock private Booking booking;
  @Mock private CancelBookingInput cancelRequest;
  @Mock private UpdateBookingInput updateRequest;

  @BeforeEach
  void setUp() {
    when(booking.bookingId()).thenReturn("b123");
    when(booking.startDate()).thenReturn("2025-05-01");
    when(booking.endDate()).thenReturn("2025-05-10");
  }

  @Test
  @DisplayName("Should create BookingCreated event with booking data")
  void shouldCreateBookingCreatedEvent() {
    givenValidPropertyIdAndGuestId();
    var event = factory.createBookingCreated(booking);

    assertThat(event.bookingId()).isEqualTo("b123");
    assertThat(event.propertyId()).isEqualTo("p456");
    assertThat(event.guestId()).isEqualTo("g789");
    assertThat(event.startDate()).isEqualTo("2025-05-01");
    assertThat(event.endDate()).isEqualTo("2025-05-10");
  }

  @Test
  @DisplayName("Should create BookingCancelled event with booking and cancelRequest data")
  void shouldCreateBookingCancelledEvent() {
    givenValidPropertyIdAndGuestId();
    when(cancelRequest.getReason()).thenReturn("Client changed plans");
    when(cancelRequest.getCancelledBy()).thenReturn("guest");
    when(cancelRequest.getCancelledAt()).thenReturn("2025-04-01T12:00:00Z");

    var event = factory.createBookingCancelled(booking, cancelRequest);

    assertThat(event.bookingId()).isEqualTo("b123");
    assertThat(event.propertyId()).isEqualTo("p456");
    assertThat(event.guestId()).isEqualTo("g789");
    assertThat(event.reason()).isEqualTo("Client changed plans");
    assertThat(event.cancelledBy()).isEqualTo("guest");
    assertThat(event.cancelledAt()).isEqualTo("2025-04-01T12:00:00Z");
  }

  @Test
  @DisplayName("Should create BookingUpdated event with booking and updateRequest data")
  void shouldCreateBookingUpdatedEvent() {
    when(updateRequest.getNewStartDate()).thenReturn("2025-06-01");
    when(updateRequest.getNewEndDate()).thenReturn("2025-06-05");
    when(updateRequest.getUpdateReason()).thenReturn("Date change by guest");

    BookingUpdated event = factory.createBookingUpdated(booking, updateRequest);

    assertThat(event.bookingId()).isEqualTo("b123");
    assertThat(event.oldStartDate()).isEqualTo("2025-05-01");
    assertThat(event.oldEndDate()).isEqualTo("2025-05-10");
    assertThat(event.newStartDate()).isEqualTo("2025-06-01");
    assertThat(event.newEndDate()).isEqualTo("2025-06-05");
    assertThat(event.updateReason()).isEqualTo("Date change by guest");
    assertThat(event.updatedAt()).isNotNull();
  }

  private void givenValidPropertyIdAndGuestId() {
    when(booking.propertyId()).thenReturn("p456");
    when(booking.guestId()).thenReturn("g789");
  }
}

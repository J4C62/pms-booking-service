package com.github.j4c62.pms.booking.domain.model;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookingTest {

  private static final String BOOKING_ID = "b123";
  private static final String PROPERTY_ID = "p456";
  private static final String GUEST_ID = "g789";
  private static final String START_DATE = "2025-05-01";
  private static final String END_DATE = "2025-05-10";

  private Booking createBooking(BookingStatus status) {
    return new Booking(BOOKING_ID, PROPERTY_ID, GUEST_ID, START_DATE, END_DATE, status);
  }

  @Test
  @DisplayName("Should return true if booking is cancelled")
  void shouldReturnTrueIfCancelled() {
    var booking = createBooking(BookingStatus.CANCELLED);
    assertThat(booking.isCancelled()).isTrue();
  }

  @Test
  @DisplayName("Should return true if booking is pending")
  void shouldReturnTrueIfPending() {
    var booking = createBooking(PENDING);
    assertThat(booking.isPending()).isTrue();
  }

  @Test
  @DisplayName("Should cancel a pending booking")
  void shouldCancelBooking() {
    var booking = createBooking(PENDING);
    var cancelled = booking.cancel();

    assertThat(cancelled.status()).isEqualTo(BookingStatus.CANCELLED);
    assertThat(cancelled.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(cancelled.startDate()).isEqualTo(START_DATE);
  }

  @Test
  @DisplayName("Should mark a booking as pending")
  void shouldMarkAsPending() {
    var booking = createBooking(BookingStatus.CANCELLED);
    var pending = booking.markAsPending();

    assertThat(pending.status()).isEqualTo(PENDING);
  }

  @Test
  @DisplayName("Should update booking dates")
  void shouldUpdateDates() {
    var booking = createBooking(PENDING);
    var updated = booking.updateDates("2025-06-01", "2025-06-10");

    assertThat(updated.startDate()).isEqualTo("2025-06-01");
    assertThat(updated.endDate()).isEqualTo("2025-06-10");
    assertThat(updated.status()).isEqualTo(PENDING);
  }

  @Test
  @DisplayName("Should throw when cancelling already cancelled booking")
  void shouldThrowWhenCancellingCancelledBooking() {
    var booking = createBooking(BookingStatus.CANCELLED);

    assertThatThrownBy(booking::validateCancellable)
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("Cannot cancel this booking");
  }

  @Test
  @DisplayName("Should pass validateCancellable when booking is pending")
  void shouldPassValidateCancellable() {
    var booking = createBooking(PENDING);

    assertThat(booking.isCancelled()).isFalse();
    assertThat(booking.isPending()).isTrue();

    assertThatCode(booking::validateCancellable).doesNotThrowAnyException();
  }

  @Test
  @DisplayName("Should throw when updating a cancelled booking")
  void shouldThrowWhenUpdatingCancelledBooking() {
    var booking = createBooking(BookingStatus.CANCELLED);

    assertThatThrownBy(() -> booking.validateUpdatable("2025-06-01", "2025-06-10"))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("Cannot update a cancelled booking");
  }

  @Test
  @DisplayName("Should throw when updating with same start date but different end date")
  void shouldThrowWhenStartDateSameButEndDateDifferent() {
    var booking = createBooking(PENDING);

    assertThatThrownBy(() -> booking.validateUpdatable(START_DATE, "2025-06-10"))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("No changes detected in booking start date");
  }

  @Test
  @DisplayName("Should throw when updating with different start date but same end date")
  void shouldThrowWhenStartDateDifferentButEndDateSame() {
    var booking = createBooking(PENDING);

    assertThatThrownBy(() -> booking.validateUpdatable("2025-06-01", END_DATE))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("No changes detected in booking end date");
  }

  @Test
  @DisplayName("Should pass validation when updating with different start and end dates")
  void shouldPassValidationWhenDatesAreDifferent() {
    var booking = createBooking(PENDING);

    assertThatCode(() -> booking.validateUpdatable("2025-06-01", "2025-06-10"))
        .doesNotThrowAnyException();
  }
}

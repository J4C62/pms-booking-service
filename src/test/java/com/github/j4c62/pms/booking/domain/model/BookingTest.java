package com.github.j4c62.pms.booking.domain.model;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit tests for Booking domain model")
class BookingTest {

  private static final UUID BOOKING_ID = UUID.randomUUID();
  private static final UUID PROPERTY_ID = UUID.randomUUID();
  private static final UUID GUEST_ID = UUID.randomUUID();
  private static final String START_DATE = "2025-05-01";
  private static final String END_DATE = "2025-05-10";

  private Booking createBooking(BookingStatus status) {
    return new Booking(BOOKING_ID, PROPERTY_ID, GUEST_ID, START_DATE, END_DATE, status);
  }

  @Test
  @DisplayName("Given cancelled booking when checking if cancelled then should return true")
  void givenCancelledBookingWhenCheckingIfCancelledThenShouldReturnTrue() {
    var booking = createBooking(BookingStatus.CANCELLED);
    assertThat(booking.isCancelled()).isTrue();
  }

  @Test
  @DisplayName("Given cancelled booking when marked as pending then should return pending booking")
  void givenCancelledBookingWhenMarkedAsPendingThenShouldReturnPendingBooking() {
    var booking = createBooking(BookingStatus.CANCELLED);
    var pending = booking.markAsPending();

    assertThat(pending.status()).isEqualTo(PENDING);
  }

  @Test
  @DisplayName("Given pending booking when updating dates then should return updated booking")
  void givenPendingBookingWhenUpdatingDatesThenShouldReturnUpdatedBooking() {
    var booking = createBooking(PENDING);
    var updated = booking.updateDates("2025-06-01", "2025-06-10");

    assertThat(updated.startDate()).isEqualTo("2025-06-01");
    assertThat(updated.endDate()).isEqualTo("2025-06-10");
    assertThat(updated.status()).isEqualTo(PENDING);
  }

  @Test
  @DisplayName("Given cancelled booking when updating then should throw IllegalStateException")
  void givenCancelledBookingWhenUpdatingThenShouldThrowIllegalStateException() {
    var booking = createBooking(BookingStatus.CANCELLED);

    assertThatThrownBy(() -> booking.validateUpdatable("2025-06-01", "2025-06-10"))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("Cannot update a cancelled booking");
  }

  @Test
  @DisplayName(
      "Given booking when updating with same start date but different end date then should throw")
  void givenBookingWhenUpdatingWithSameStartDateButDifferentEndDateThenShouldThrow() {
    var booking = createBooking(PENDING);

    assertThatThrownBy(() -> booking.validateUpdatable(START_DATE, "2025-06-10"))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("No changes detected in booking start date");
  }

  @Test
  @DisplayName(
      "Given booking when updating with different start date but same end date then should throw")
  void givenBookingWhenUpdatingWithDifferentStartDateButSameEndDateThenShouldThrow() {
    var booking = createBooking(PENDING);

    assertThatThrownBy(() -> booking.validateUpdatable("2025-06-01", END_DATE))
        .isExactlyInstanceOf(IllegalStateException.class)
        .hasMessageContaining("No changes detected in booking end date");
  }

  @Test
  @DisplayName(
      "Given booking when updating with different start and end dates then should pass validation")
  void givenBookingWhenUpdatingWithDifferentStartAndEndDatesThenShouldPassValidation() {
    var booking = createBooking(PENDING);

    assertThatCode(() -> booking.validateUpdatable("2025-06-01", "2025-06-10"))
        .doesNotThrowAnyException();
  }
}

package com.github.j4c62.pms.booking.domain.creation.factory;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.application.creation.factory.BookingAssembler;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingAssemblerTest {

  private BookingAssembler bookingAssembler;

  @Mock private CreateBookingInput createRequest;

  @BeforeEach
  void setUp() {
    bookingAssembler = new BookingAssembler();
  }

  @Test
  @DisplayName("Should create a valid Booking when all fields are valid")
  void shouldToBookingValidBooking() {
    givenValidRequest();
    givenValidDates();
    var booking = bookingAssembler.toBooking(createRequest);

    assertThat(booking).isNotNull();
    assertThat(booking.bookingId()).isNotNull();
    assertThat(booking.propertyId()).isEqualTo("property123");
    assertThat(booking.guestId()).isEqualTo("guest456");
    assertThat(booking.startDate()).isEqualTo("2025-05-01");
    assertThat(booking.endDate()).isEqualTo("2025-05-10");
    assertThat(booking.status()).isEqualTo(PENDING);
  }

  // --- PropertyId validations ---
  @Test
  @DisplayName("Should throw NullPointerException when propertyId is null")
  void shouldThrowWhenPropertyIdIsNull() {
    when(createRequest.getPropertyId()).thenReturn(null);
    assertThrowsNullPointer("Property ID");
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when propertyId is blank")
  void shouldThrowWhenPropertyIdIsBlank() {
    givenValidRequest();
    givenValidDates();
    when(createRequest.getPropertyId()).thenReturn("  ");
    assertThrowsIllegalArgument("Property ID");
  }

  // --- GuestId validations ---
  @Test
  @DisplayName("Should throw NullPointerException when guestId is null")
  void shouldThrowWhenGuestIdIsNull() {
    givenValidRequest();
    when(createRequest.getGuestId()).thenReturn(null);
    assertThrowsNullPointer("Guest ID");
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when guestId is blank")
  void shouldThrowWhenGuestIdIsBlank() {
    givenValidRequest();
    givenValidDates();
    when(createRequest.getGuestId()).thenReturn("");
    assertThrowsIllegalArgument("Guest ID");
  }

  // --- StartDate validations ---
  @Test
  @DisplayName("Should throw NullPointerException when startDate is null")
  void shouldThrowWhenStartDateIsNull() {
    givenValidRequest();
    when(createRequest.getStartDate()).thenReturn(null);
    assertThrowsNullPointer("Start Date");
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when startDate is invalid format")
  void shouldThrowWhenStartDateIsInvalidFormat() {
    givenValidRequest();
    givenValidDates();
    when(createRequest.getStartDate()).thenReturn("bad-format");
    assertThrowsIllegalArgument("Start date");
  }

  // --- EndDate validations ---
  @Test
  @DisplayName("Should throw NullPointerException when endDate is null")
  void shouldThrowWhenEndDateIsNull() {
    givenValidRequest();
    when(createRequest.getStartDate()).thenReturn("2025-05-01");
    when(createRequest.getEndDate()).thenReturn(null);
    assertThrowsNullPointer("End Date");
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when endDate is invalid format")
  void shouldThrowWhenEndDateIsInvalidFormat() {
    givenValidRequest();
    givenValidDates();
    when(createRequest.getEndDate()).thenReturn("32/13/2030");
    assertThrowsIllegalArgument("End date");
  }

  // --- Date logic validations ---
  @Test
  @DisplayName("Should throw IllegalArgumentException when startDate is after endDate")
  void shouldThrowWhenStartDateIsAfterEndDate() {
    givenValidRequest();
    when(createRequest.getStartDate()).thenReturn("2025-06-01");
    when(createRequest.getEndDate()).thenReturn("2025-05-01");
    assertThrowsIllegalArgument("must be before end date");
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when endDate is in the past")
  void shouldThrowWhenEndDateIsInThePast() {
    givenValidRequest();
    when(createRequest.getStartDate()).thenReturn("2019-05-01");
    when(createRequest.getEndDate()).thenReturn("2020-01-01");
    assertThrowsIllegalArgument("must not be in the past");
  }

  // -------------------------
  // Helpers
  // -------------------------
  void givenValidRequest() {
    when(createRequest.getPropertyId()).thenReturn("property123");
    when(createRequest.getGuestId()).thenReturn("guest456");
  }

  private void givenValidDates() {
    when(createRequest.getStartDate()).thenReturn("2025-05-01");
    when(createRequest.getEndDate()).thenReturn("2025-05-10");
  }

  void assertThrowsNullPointer(String expectedMessagePart) {
    assertThatThrownBy(() -> bookingAssembler.toBooking(createRequest))
        .isExactlyInstanceOf(NullPointerException.class)
        .hasMessageContaining(expectedMessagePart);
  }

  void assertThrowsIllegalArgument(String expectedMessagePart) {
    assertThatThrownBy(() -> bookingAssembler.toBooking(createRequest))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expectedMessagePart);
  }
}

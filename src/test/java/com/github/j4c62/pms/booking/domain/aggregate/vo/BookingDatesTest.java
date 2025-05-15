package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class BookingDatesTest {

  private static BookingDates getBookingDates() {
    return BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
  }

  private static boolean checkIsSameAs(LocalDate startDate, LocalDate endDate) {
    var datesToCheck = getBookingDates();
    var otherDates = BookingDates.of(startDate, endDate);
    return datesToCheck.isSameAs(otherDates);
  }

  private static void thenConstructorThrowsIllegalArgumentException(
      LocalDate startDate, String message) {
    assertThatThrownBy(() -> BookingDates.of(startDate, LocalDate.now()))
        .as("Should throw IllegalArgumentException with message: %s", message)
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains(message);
  }

  private static void thenConstructorThrowsNullPointerException(
      LocalDate startDate, LocalDate endDate, String message) {
    assertThatThrownBy(() -> BookingDates.of(startDate, endDate))
        .as("Should throw NullPointerException with message: %s", message)
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains(message);
  }

  @Test
  void givenStartDateNullWhenCreateBookingDatesThenThrowNullPointerException() {
    thenConstructorThrowsNullPointerException(null, LocalDate.now(), "Start date cannot be null");
  }

  @Test
  void givenEndDateNullWhenCreateBookingDatesThenThrowNullPointerException() {
    thenConstructorThrowsNullPointerException(LocalDate.now(), null, "End date cannot be null");
  }

  @Test
  void givenStartDateAfterEndDateWhenCreateBookingDatesIllegalArgumentException() {
    thenConstructorThrowsIllegalArgumentException(
        LocalDate.now().plusDays(2), "Start date must be before end date");
  }

  @Test
  void givenStartDateInPastWhenCreateBookingDatesIllegalArgumentException() {
    thenConstructorThrowsIllegalArgumentException(
        LocalDate.of(2024, 2, 3), "Start date must not be in the past");
  }

  @Test
  void givenValidStartDateWhenCreateBookingDatesThenBookingDatesCreated() {
    var bookingDates = getBookingDates();
    assertThat(bookingDates)
        .as("BookingDates object should be created and not null for valid input")
        .isNotNull();
  }

  @Test
  void givenDifferentStartDatesWhenCheckIsSameThatOtherDatesThenReturnFalse() {
    var isSameAs = checkIsSameAs(LocalDate.now().plusDays(2), LocalDate.now().plusDays(2));
    assertThat(isSameAs)
        .as("Expected isSameAs() to return false for different start dates")
        .isFalse();
  }

  @Test
  void givenDifferentEndDatesWhenCheckIsSameThatOtherDatesThenReturnFalse() {
    var isSameAs = checkIsSameAs(LocalDate.now(), LocalDate.now().plusDays(3));
    assertThat(isSameAs)
        .as("Expected isSameAs() to return false for different end dates")
        .isFalse();
  }

  @Test
  void givenIdenticalBookingDatesWhenCheckIsSameThatOtherDatesThenReturnTrue() {
    var isSameAs = checkIsSameAs(LocalDate.now(), LocalDate.now().plusDays(2));
    assertThat(isSameAs)
        .as("Expected isSameAs() to return true for identical booking dates")
        .isTrue();
  }
}

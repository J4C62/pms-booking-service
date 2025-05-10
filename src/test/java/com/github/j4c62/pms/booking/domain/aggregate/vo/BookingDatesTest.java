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
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains(message);
  }

  private static void thenConstructorThrowsNullPointerException(
      LocalDate startDate, LocalDate endDate, String message) {
    assertThatThrownBy(() -> BookingDates.of(startDate, endDate))
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains(message);
  }

  @Test
  void givenAStartDateNullWhenCreateBookingDatesThenThrowNullPointerException() {
    thenConstructorThrowsNullPointerException(null, LocalDate.now(), "Start date cannot be null");
  }

  @Test
  void givenAEndDateNullWhenCreateBookingDatesThenThrowNullPointerException() {
    thenConstructorThrowsNullPointerException(LocalDate.now(), null, "End date cannot be null");
  }

  @Test
  void givenAStartDateAfterEndDateWhenCreateBookingDatesIllegalArgumentException() {
    thenConstructorThrowsIllegalArgumentException(
        LocalDate.now().plusDays(2), "Start date must be before end date");
  }

  @Test
  void givenAStartDateInPastWhenCreateBookingDatesIllegalArgumentException() {
    thenConstructorThrowsIllegalArgumentException(
        LocalDate.of(2024, 2, 3), "Start date must not be in the past");
  }

  @Test
  void givenAValidStartDateWhenCreateBookingDatesThenBookingDatesCreated() {
    var bookingDates = getBookingDates();
    assertThat(bookingDates).isNotNull();
  }

  @Test
  void givenDifferentStartDatesWhenCheckIsSameThatOtherDatesThenReturnFalse() {
    var isSameAs = checkIsSameAs(LocalDate.now().plusDays(2), LocalDate.now().plusDays(2));
    assertThat(isSameAs).isFalse();
  }

  @Test
  void givenDifferentEndDatesWhenCheckIsSameThatOtherDatesThenReturnFalse() {
    var isSameAs = checkIsSameAs(LocalDate.now(), LocalDate.now().plusDays(3));
    assertThat(isSameAs).isFalse();
  }

  @Test
  void givenAIdenticalBookingDatesWhenCheckIsSameThatOtherDatesThenReturnTrue() {
    var isSameAs = checkIsSameAs(LocalDate.now(), LocalDate.now().plusDays(2));
    assertThat(isSameAs).isTrue();
  }
}

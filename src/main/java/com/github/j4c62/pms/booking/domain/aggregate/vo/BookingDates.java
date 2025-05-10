package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.requireStartBeforeEnd;
import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.requireStartNotInPast;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

public record BookingDates(LocalDate startDate, LocalDate endDate) {
  public BookingDates {
    requireNonNull(startDate, "Start date cannot be null");
    requireNonNull(endDate, "End date cannot be null");
    requireStartBeforeEnd(startDate, endDate);
    requireStartNotInPast(startDate);
  }

  public static BookingDates of(LocalDate start, LocalDate end) {
    return new BookingDates(start, end);
  }

  public boolean isSameAs(BookingDates other) {
    return this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate);
  }
}

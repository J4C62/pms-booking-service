package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.domain.shared.validator.Validator;
import java.time.LocalDate;

public record BookingDates(LocalDate startDate, LocalDate endDate) {
  public BookingDates {
    requireNonNull(startDate, "Start date cannot be null");
    requireNonNull(endDate, "End date cannot be null");
    startBeforeEnd.validate(this);
    startNotInPast.validate(this);
  }

  public boolean isSameAs(BookingDates other) {
    return this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate);
  }

  private static final Validator<BookingDates> startBeforeEnd =
      dates -> {
        if (dates.startDate().isAfter(dates.endDate())) {
          throw new IllegalArgumentException("Start date must be before end date");
        }
      };

  private static final Validator<BookingDates> startNotInPast =
      dates -> {
        if (dates.startDate().isBefore(LocalDate.now())) {
          throw new IllegalArgumentException("Start date must not be in the past");
        }
      };
}

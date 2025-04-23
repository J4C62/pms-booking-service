package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.*;
import static java.util.Objects.requireNonNull;

public record BookingDates(String startDate, String endDate) {
  public BookingDates {
    requireNonNull(startDate, "Start date cannot be null");
    requireNonNull(endDate, "End date cannot be null");
    requireValidDate(startDate, "Start date");
    requireValidDate(endDate, "End date");
    requireStartBeforeEnd(startDate, endDate);
    requireStartNotInPast(startDate);
  }

  public boolean isSameAs(BookingDates other) {
    return this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate);
  }
}

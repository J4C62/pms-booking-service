package com.github.j4c62.pms.booking.domain.shared.validator;

import java.time.LocalDate;

public class ValidatorHelper {

  private ValidatorHelper() {}

  public static void requireStartBeforeEnd(LocalDate startDate, LocalDate endDate) {
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("Start date must be before end date");
    }
  }

  public static void requireStartNotInPast(LocalDate startDate) {
    if (startDate.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Start date must not be in the past");
    }
  }
}

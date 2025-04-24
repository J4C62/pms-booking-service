package com.github.j4c62.pms.booking.domain.shared.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidatorHelper {
  public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

package com.github.j4c62.pms.booking.domain.shared.validator;

import static com.github.j4c62.pms.booking.domain.shared.exception.SafeExecutor.tryOpt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidatorHelper {
  public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private ValidatorHelper() {}

  public static void requireNotBlank(String value, String fieldName) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException(fieldName + " cannot be blank");
    }
  }

  public static void requireValidDate(String dateStr, String fieldName) {
    tryOpt(ValidatorHelper::parseDate, dateStr)
        .orElseThrow(() -> new IllegalArgumentException("Invalid " + fieldName));
  }

  public static void requireStartBeforeEnd(String startDate, String endDate) {
    LocalDate start = parseDate(startDate);
    LocalDate end = parseDate(endDate);
    if (start.isAfter(end)) {
      throw new IllegalArgumentException("Start date cannot be after end date");
    }
  }

  public static void requireStartNotInPast(String startDate) {
    LocalDate start = parseDate(startDate);
    if (start.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Start date cannot be in the past");
    }
  }

  public static String actualDate() {
    return LocalDate.now().format(FORMATTER);
  }

  public static LocalDate parseDate(String dateStr) {
    return LocalDate.parse(dateStr, FORMATTER);
  }
}

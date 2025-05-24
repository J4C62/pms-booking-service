package com.github.j4c62.pms.booking.domain.shared.validator;

import java.time.LocalDate;

/**
 * Utility class providing domain-specific validation methods for booking date constraints.
 *
 * <p>This class enforces invariants related to {@code LocalDate} usage within booking operations,
 * such as ensuring start dates are not in the past and that they precede end dates.
 *
 * <p>This is a static utility class and cannot be instantiated.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-16
 */
public final class ValidatorHelper {

  private ValidatorHelper() {}

  /**
   * Validates that the start date is before or equal to the end date.
   *
   * @param startDate the start date to validate; must not be {@code null}
   * @param endDate the end date to validate; must not be {@code null}
   * @throws IllegalArgumentException if {@code startDate} is after {@code endDate}
   * @author Jose Antonio (J4c62)
   * @since 2025-04-16
   */
  public static void requireStartBeforeEnd(LocalDate startDate, LocalDate endDate) {
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("start_date must be before end_date");
    }
  }

  /**
   * Validates that the start date is not in the past relative to the current system date.
   *
   * @param startDate the start date to validate; must not be {@code null}
   * @throws IllegalArgumentException if {@code startDate} is before today
   * @author Jose Antonio (J4c62)
   * @since 2025-04-16
   */
  public static void requireStartNotInPast(LocalDate startDate) {
    if (startDate.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("start_date must not be in the past");
    }
  }
}

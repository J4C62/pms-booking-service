package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.requireStartBeforeEnd;
import static com.github.j4c62.pms.booking.domain.shared.validator.ValidatorHelper.requireStartNotInPast;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

/**
 * Value object representing the start and end dates of a booking.
 *
 * <p>Ensures that the date range is valid by enforcing domain invariants: the start date must not
 * be in the past, and must be before the end date.
 *
 * <p>This class is immutable and performs validation at construction time to guarantee consistency
 * across the system.
 *
 * @param startDate The check-in date of the booking.
 * @param endDate The check-out date of the booking.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-25
 */
public record BookingDates(LocalDate startDate, LocalDate endDate) {
  /**
   * Constructs a {@code BookingDates} object with the given start and end dates, enforcing business
   * rules for date validity.
   *
   * @param startDate The check-in date; must not be null or in the past.
   * @param endDate The check-out date; must not be null and must be after the start date.
   * @throws NullPointerException if either date is null.
   * @throws IllegalArgumentException if start date is after or equal to end date, or if the start
   *     date is in the past.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-25
   */
  public BookingDates {
    requireNonNull(startDate, "start_date cannot be null");
    requireNonNull(endDate, "end_date cannot be null");
    requireStartBeforeEnd(startDate, endDate);
    requireStartNotInPast(startDate);
  }

  /**
   * Static factory method to create a {@link BookingDates} instance.
   *
   * @param start The start date of the booking.
   * @param end The end date of the booking.
   * @return A validated {@code BookingDates} object.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingDates of(LocalDate start, LocalDate end) {
    return new BookingDates(start, end);
  }

  /**
   * Compares this {@code BookingDates} instance to another for equality.
   *
   * @param other The other {@code BookingDates} to compare with.
   * @return {@code true} if both start and end dates are equal, {@code false} otherwise.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-25
   */
  public boolean isSameAs(BookingDates other) {
    return this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate);
  }
}

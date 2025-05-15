package com.github.j4c62.pms.booking.domain.aggregate.vo;

/**
 * Enumeration representing the status of a booking within the system.
 *
 * <p>Booking statuses describe the lifecycle state of a {@code BookingAggregate}.
 *
 * <ul>
 *   <li>{@link #PENDING} - The booking has been created but not yet confirmed.
 *   <li>{@link #CANCELLED} - The booking has been cancelled and is no longer active.
 *   <li>{@link #CONFIRMED} - The booking has been confirmed and is considered active.
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-15
 */
public enum BookingStatus {
  PENDING,
  CANCELLED,
  CONFIRMED;

  public boolean isCancelled() {
    return this == CANCELLED;
  }
}

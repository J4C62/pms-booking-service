package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

/**
 * Value object representing the unique identifier of a booking.
 *
 * <p>This class wraps a {@link UUID} and enforces non-nullability at construction time.
 *
 * <p>Used throughout the domain model to uniquely reference a {@code BookingAggregate}.
 *
 * @param value The UUID that uniquely identifies a booking.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingId(UUID value) {
  /**
   * Constructs a new {@code BookingId} instance, ensuring the value is not null.
   *
   * @param value The UUID to wrap.
   * @throws NullPointerException if {@code value} is null.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingId {
    requireNonNull(value, "Booking ID cannot be null");
  }

  /**
   * Factory method for creating a {@code BookingId} from a given UUID.
   *
   * @param value The UUID to wrap.
   * @return A new {@code BookingId} instance.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingId of(UUID value) {
    return new BookingId(value);
  }
}

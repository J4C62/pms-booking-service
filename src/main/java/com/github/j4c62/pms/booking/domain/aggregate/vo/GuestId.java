package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

/**
 * Value object representing the unique identifier of a guest.
 *
 * <p>This class wraps a non-null {@link UUID} to ensure type safety and immutability when
 * referencing guests across the domain.
 *
 * @param value The UUID that uniquely identifies a guest.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record GuestId(UUID value) {
  /**
   * Constructs a new {@code GuestId}, ensuring the provided value is not null.
   *
   * @param value The UUID to wrap.
   * @throws NullPointerException if {@code value} is {@code null}.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public GuestId {
    requireNonNull(value, "guest_id cannot be null");
  }

  /**
   * Static factory method to create a {@code GuestId} from a given UUID.
   *
   * @param value The UUID representing the guest's identifier.
   * @return A new {@code GuestId} instance.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static GuestId of(UUID value) {
    return new GuestId(value);
  }
}

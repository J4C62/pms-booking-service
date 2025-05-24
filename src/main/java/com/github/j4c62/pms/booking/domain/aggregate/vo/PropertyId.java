package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

/**
 * Value object representing the unique identifier of a property.
 *
 * <p>This class encapsulates a non-null {@link UUID}, providing type safety and immutability when
 * referencing properties throughout the domain model.
 *
 * @param value The UUID that uniquely identifies a property.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record PropertyId(UUID value) {
  /**
   * Constructs a new {@code PropertyId}, validating that the provided UUID is not {@code null}.
   *
   * @param value The UUID to wrap.
   * @throws NullPointerException if {@code value} is {@code null}.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public PropertyId {
    requireNonNull(value, "property_id cannot be null");
  }

  /**
   * Static factory method to create a {@code PropertyId} from a given UUID.
   *
   * @param value The UUID representing the property's identifier.
   * @return A new {@code PropertyId} instance.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static PropertyId of(UUID value) {
    return new PropertyId(value);
  }
}

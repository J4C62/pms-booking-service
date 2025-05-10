package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public record PropertyId(UUID value) {
  public PropertyId {
    requireNonNull(value, "Property ID cannot be null");
  }

  public static PropertyId of(UUID value) {
    return new PropertyId(value);
  }
}

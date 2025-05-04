package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public record GuestId(UUID value) {
  public GuestId {
    requireNonNull(value, "Guest ID cannot be null");
  }
}

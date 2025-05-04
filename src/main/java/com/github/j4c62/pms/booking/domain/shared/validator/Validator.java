package com.github.j4c62.pms.booking.domain.shared.validator;

@FunctionalInterface
public interface Validator<T> {
  void validate(T value);
}

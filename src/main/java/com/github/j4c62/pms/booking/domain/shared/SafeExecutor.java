package com.github.j4c62.pms.booking.domain.shared;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SafeExecutor {
  public static final Logger logger = Logger.getLogger(SafeExecutor.class.getName());

  private SafeExecutor() {}

  public static <A, T> Optional<T> tryOpt(FunctionWithException<A, T> function, A arg) {
    try {
      return Optional.of(function.apply(arg));
    } catch (Exception e) {
      logger.log(Level.WARNING, String.format("Exception occurred: %s", e.getMessage()), e);
      return Optional.empty();
    }
  }
}

package com.github.j4c62.pms.booking.domain.shared;

@FunctionalInterface
public interface FunctionWithException<A, T> {
  T apply(A a) throws Exception;
}

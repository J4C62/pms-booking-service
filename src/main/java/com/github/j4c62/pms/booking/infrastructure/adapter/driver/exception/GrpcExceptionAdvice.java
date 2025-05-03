package com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcExceptionAdvice {

  @GrpcExceptionHandler(IllegalArgumentException.class)
  public Status handleInvalidArgument(IllegalArgumentException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }
  @GrpcExceptionHandler(IllegalStateException.class)
  public Status handleInvalidArgument(IllegalStateException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }

  @GrpcExceptionHandler(NullPointerException.class)
  public Status handleNullPointerArgument(NullPointerException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }
}

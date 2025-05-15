package com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

/**
 * Global gRPC exception handler using {@code @GrpcAdvice}.
 *
 * <p>This class maps common Java exceptions to appropriate gRPC {@link io.grpc.Status} codes to
 * ensure meaningful error responses are returned to gRPC clients.
 *
 * <p>All handled exceptions in this class are mapped to {@link Status#INVALID_ARGUMENT}, indicating
 * client-side errors due to invalid or illegal input or state.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-22
 */
@GrpcAdvice
public class GrpcExceptionAdvice {
  /**
   * Handles {@link IllegalArgumentException} by returning {@link Status#INVALID_ARGUMENT}.
   *
   * @param e the exception thrown during execution
   * @return a gRPC {@link Status} with description and cause
   * @author Jose Antonio (J4c62)
   * @since 2025-04-22
   */
  @GrpcExceptionHandler(IllegalArgumentException.class)
  public Status handleInvalidArgument(IllegalArgumentException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }

  /**
   * Handles {@link IllegalStateException} by returning {@link Status#INVALID_ARGUMENT}.
   *
   * @param e the exception thrown during execution
   * @return a gRPC {@link Status} with description and cause
   * @author Jose Antonio (J4c62)
   * @since 2025-05-03
   */
  @GrpcExceptionHandler(IllegalStateException.class)
  public Status handleInvalidArgument(IllegalStateException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }

  /**
   * Handles {@link NullPointerException} by returning {@link Status#INVALID_ARGUMENT}.
   *
   * @param e the exception thrown during execution
   * @return a gRPC {@link Status} with description and cause
   * @author Jose Antonio (J4c62)
   * @since 2025-04-22
   */
  @GrpcExceptionHandler(NullPointerException.class)
  public Status handleNullPointerArgument(NullPointerException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }
}

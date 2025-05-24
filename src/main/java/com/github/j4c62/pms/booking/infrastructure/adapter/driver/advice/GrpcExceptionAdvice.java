package com.github.j4c62.pms.booking.infrastructure.adapter.driver.advice;

import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GrpcExceptionAdvice {
  /**
   * Handles {@link IllegalArgumentException} {@link IllegalStateException} {@link
   * NullPointerException} by returning {@link Status#INVALID_ARGUMENT}.
   *
   * @param e the exception thrown during execution
   * @return a gRPC {@link Status} with description and cause
   * @author Jose Antonio (J4c62)
   * @since 2025-04-22
   */
  @GrpcExceptionHandler({
    IllegalArgumentException.class,
    IllegalStateException.class,
    NullPointerException.class
  })
  public Status handleInvalidArgument(RuntimeException e) {
    log.warn(
        "[advice] RuntimeException - type={}, message={}, cause={}",
        e.getClass().getSimpleName(),
        e.getMessage(),
        e.getCause(),
        e);

    return Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e);
  }

  /**
   * Handles {@link Exception} by returning {@link Status#INTERNAL}.
   *
   * @param e the exception thrown during execution
   * @return a gRPC {@link Status} with description and cause
   * @author Jose Antonio (J4c62)
   * @since 2025-06-24
   */
  @GrpcExceptionHandler(Exception.class)
  public Status handleException(Exception e) {
    log.warn("[advice] Critical error: cause:{}", e.getMessage());
    return Status.INTERNAL.withDescription(e.getMessage()).withCause(e);
  }

}

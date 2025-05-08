package com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception;

import static org.assertj.core.api.Assertions.assertThat;

import io.grpc.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(GrpcExceptionAdvice.class)
class GrpcExceptionAdviceTest {

  @Autowired private GrpcExceptionAdvice advice;

  @Test
  void givenIllegalArgumentExceptionWhenHandledThenReturnsInvalidArgumentStatus() {
    var ex = new IllegalArgumentException("Invalid input");
    var status = advice.handleInvalidArgument(ex);

    assertThat(status.getCode()).isEqualTo(Status.Code.INVALID_ARGUMENT);
    assertThat(status.getDescription()).isEqualTo("Invalid input");
    assertThat(status.getCause()).isEqualTo(ex);
  }

  @Test
  void givenIllegalStateExceptionWhenHandledThenReturnsInvalidArgumentStatus() {
    var ex = new IllegalStateException("Illegal state");
    var status = advice.handleInvalidArgument(ex);

    assertThat(status.getCode()).isEqualTo(Status.Code.INVALID_ARGUMENT);
    assertThat(status.getDescription()).isEqualTo("Illegal state");
    assertThat(status.getCause()).isEqualTo(ex);
  }

  @Test
  void givenNullPointerExceptionWhenHandledThenReturnsInvalidArgumentStatus() {
    var ex = new NullPointerException("Null found");
    var status = advice.handleNullPointerArgument(ex);

    assertThat(status.getCode()).isEqualTo(Status.Code.INVALID_ARGUMENT);
    assertThat(status.getDescription()).isEqualTo("Null found");
    assertThat(status.getCause()).isEqualTo(ex);
  }
}

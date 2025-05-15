package com.github.j4c62.pms.booking.application.strategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.application.strategy.executor.BookingCommandExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(ApplicationFixture.class)
class BookingCommandExecutorTest {
  @Autowired BookingCommandExecutor bookingCommandExecutor;

  @Test
  @SuppressWarnings("DataFlowIssue")
  void givenNullCommandThenThrowsNullPointerException() {
    assertThatThrownBy(() -> bookingCommandExecutor.execute(null))
        .as("Expected NullPointerException when executing a null command")
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains("command is marked non-null but is null");
  }

  @Test
  void givenUnsupportedCommandThenThrowsIllegalArgumentException() {
    assertThatThrownBy(() -> bookingCommandExecutor.execute(aggregate -> null))
        .as("Expected IllegalArgumentException for unsupported command type")
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains("Unsupported command type");
  }
}

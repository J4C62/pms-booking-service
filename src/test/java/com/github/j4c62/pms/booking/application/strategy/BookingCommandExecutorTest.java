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
  void givenANullCommandThenThrowsNullPointerException() {
    assertThatThrownBy(() -> bookingCommandExecutor.execute(null))
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains("command is marked non-null but is null");
  }

  @Test
  void givenAUnsupportedCommandThenThrowsIllegalArgumentException() {
    assertThatThrownBy(() -> bookingCommandExecutor.execute(aggregate -> null))
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains("Unsupported command type");
  }
}

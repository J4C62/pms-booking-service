package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.j4c62.pms.booking.application.ApplicationFixture;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(ApplicationFixture.class)
class BookingCommandHandlerTest {

  @Test
  void givenANullCommandThenReturnNullPointerException(
      @Autowired BookingHandler bookingCommandHandler) {
    assertThatThrownBy(() -> bookingCommandHandler.handle(null))
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains("command is marked non-null but is null");
  }
}

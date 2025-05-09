package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.strategy.executor.BookingCommandExecutor;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingCommandHandler implements BookingHandler {
  private final BookingCommandExecutor bookingCommandExecutor;

  @Override
  public BookingOutput handle(@NonNull Command command) {
    return bookingCommandExecutor.execute(command);
  }
}

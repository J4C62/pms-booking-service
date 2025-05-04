package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingCommandExecutor {

  private final List<BookingCommandStrategy<? extends Command>> strategies;

  @SuppressWarnings("unchecked")
  public BookingOutput execute(@NonNull Command command) {
    return strategies.stream()
        .filter(s -> s.supports(command))
        .findFirst()
        .map(strategy -> ((BookingCommandStrategy<Command>) strategy).execute(command))
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "Unsupported command type: %s".formatted(command.getClass())));
  }
}

package com.github.j4c62.pms.booking.application.strategy.executor;

import com.github.j4c62.pms.booking.application.strategy.BookingCommandStrategy;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Central executor that delegates {@link Command} processing to the appropriate {@link
 * BookingCommandStrategy} based on command type.
 *
 * <p>This component serves as a dynamic router that selects the correct strategy implementation for
 * the given command, enabling open-closed principle by allowing new strategies to be added without
 * modifying this class.
 *
 * <p>It is intended to be used by services such as {@link
 * com.github.j4c62.pms.booking.application.handler.BookingCommandHandler} to abstract away the
 * logic of finding and executing the correct handler for each command.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-30
 */
@Component
@RequiredArgsConstructor
public class BookingCommandExecutor {

  private final List<BookingCommandStrategy<? extends Command>> strategies;

  /**
   * Executes the given {@link Command} by delegating to the matching strategy.
   *
   * @param command The command to be executed.
   * @return The result of the command execution as a {@link BookingOutput}.
   * @throws IllegalArgumentException if no strategy supports the given command type.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
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

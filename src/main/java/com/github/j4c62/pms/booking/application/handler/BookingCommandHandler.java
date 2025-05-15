package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.strategy.executor.BookingCommandExecutor;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Application service that handles incoming {@link Command} objects related to bookings.
 *
 * <p>This service delegates the actual execution of the command to the {@link
 * BookingCommandExecutor}, which applies the appropriate strategy based on the command type (e.g.,
 * create, update, cancel).
 *
 * <p>It acts as an entry point in the application layer for command-based interactions,
 * encapsulating the orchestration of domain logic without exposing implementation details.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-27
 */
@Service
@RequiredArgsConstructor
public class BookingCommandHandler implements BookingHandler {
  private final BookingCommandExecutor bookingCommandExecutor;

  /**
   * Handles a given {@link Command} by delegating its execution to the command executor.
   *
   * @param command The command to be processed (e.g., create, update, cancel).
   * @return The {@link BookingOutput} result after applying the command.
   * @throws IllegalArgumentException if the command type is unsupported.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-27
   */
  @Override
  public BookingOutput handle(@NonNull Command command) {
    return bookingCommandExecutor.execute(command);
  }
}

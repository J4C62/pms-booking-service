package com.github.j4c62.pms.booking.domain.driver.handler;

import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

/**
 * Central interface for handling {@link Command} instances that operate on booking aggregates.
 *
 * <p>A {@code BookingHandler} is responsible for delegating incoming commands to the appropriate
 * processing logic (e.g., creation, updates, confirmation, cancellation), and returning the
 * resulting {@link BookingOutput}.
 *
 * <p>This abstraction enables decoupling between the command invocation layer (e.g., controllers,
 * APIs) and the domain logic that processes each specific command.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-27
 */
@FunctionalInterface
public interface BookingHandler {

  /**
   * Handles the given {@link Command} and returns the result of applying it to a booking aggregate.
   *
   * @param command the command to handle; must not be {@code null}
   * @return the output resulting from applying the command
   * @throws IllegalArgumentException if the command type is not supported
   * @author Jose Antonio (J4c62)
   * @since 2025-04-27
   */
  BookingOutput handle(Command command);
}

package com.github.j4c62.pms.booking.domain.driver.command;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;

/**
 * Represents a command that can be applied to a {@link BookingAggregate} to produce a new state.
 *
 * <p>A command encapsulates an intention to perform an action or state change in the system, but
 * does not directly execute that change. Instead, it is translated into one or more {@link
 * com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent} instances when applied.
 *
 * <p>This interface is a key part of a Command-Event architecture, enabling clear separation
 * between user intent and domain event generation.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-27
 */
@FunctionalInterface
public interface Command {
  /**
   * Applies this command to the given {@link BookingAggregate}, producing an updated aggregate. The
   * result reflects the state after the corresponding {@link
   * com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent} has been applied.
   *
   * @param aggregate the current aggregate to apply the command to; may be {@code null} for
   *     creation commands
   * @return the new {@link BookingAggregate} representing the updated state
   * @author Jose Antonio (J4c62)
   * @since 2025-04-27
   */
  BookingAggregate applyTo(BookingAggregate aggregate);
}

package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.application.dispatcher.BookingEventDispatcher;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;

/**
 * Strategy interface for handling specific types of {@link Command} operations within the booking
 * domain.
 *
 * <p>Implementations of this interface encapsulate the logic to handle a particular type of command
 * (e.g., create, cancel, update booking), allowing for clean separation of concerns and open
 * extension for new command types.
 *
 * @param <T> The specific type of command this strategy handles.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-30
 */
public sealed interface BookingCommandStrategy<T extends Command>
    permits UpdateBookingCommandStrategy, CreateBookingCommandStrategy {
  /**
   * Determines whether this strategy is capable of handling the given command.
   *
   * @param command The command to evaluate.
   * @return {@code true} if the strategy supports this command; {@code false} otherwise.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  boolean supports(Command command);

  /**
   * Executes the command, applying domain logic to produce a {@link BookingOutput}.
   *
   * @param command The command to execute.
   * @return The output DTO representing the result of the command execution.
   * @throws IllegalStateException or other domain-specific exceptions if business rules are
   *     violated.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  BookingOutput execute(T command);

  /**
   * Default helper method to apply a command to a {@link BookingAggregate}, dispatch the resulting
   * domain events, and map the result to a {@link BookingOutput}.
   *
   * @param command The domain command to apply.
   * @param aggregate The aggregate to which the command will be applied.
   * @param dispatcher The event dispatcher responsible for publishing domain events.
   * @param outputMapper The mapper to convert the updated aggregate into a {@link BookingOutput}.
   * @return The final output DTO representing the command result.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-25
   */
  default BookingOutput handle(
      T command,
      BookingAggregate aggregate,
      BookingEventDispatcher dispatcher,
      BookingOutputMapper outputMapper) {
    var updatedAggregate = command.applyTo(aggregate);
    dispatcher.dispatch(updatedAggregate);
    return outputMapper.toBookingOutput(updatedAggregate);
  }
}

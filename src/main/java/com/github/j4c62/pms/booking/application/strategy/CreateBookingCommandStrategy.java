package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.application.dispatcher.BookingEventDispatcher;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.types.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import org.springframework.stereotype.Component;

/**
 * Strategy for handling {@link CreateBookingCommand} operations.
 *
 * <p>This class implements the logic required to create a new booking from the input command. It
 * maps the command to a {@link BookingAggregate}, applies domain logic via the command itself,
 * publishes the resulting domain event, and transforms the updated aggregate into an output DTO.
 *
 * <p>This strategy is automatically selected by the {@link
 * com.github.j4c62.pms.booking.application.strategy.executor.BookingCommandExecutor} when a {@code
 * CreateBookingCommand} is received.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-30
 */
@Component
public record CreateBookingCommandStrategy(
    BookingAggregateMapper bookingAggregateMapper,
    BookingEventDispatcher bookingEventDispatcher,
    BookingOutputMapper bookingOutputMapper)
    implements BookingCommandStrategy<CreateBookingCommand> {

  /**
   * Checks if this strategy supports the given command.
   *
   * @param command The command to check.
   * @return {@code true} if the command is an instance of {@link CreateBookingCommand}.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  @Override
  public boolean supports(Command command) {
    return command instanceof CreateBookingCommand;
  }

  /**
   * Executes the creation of a booking.
   *
   * <ul>
   *   <li>Maps the command to a new {@link BookingAggregate} using the mapper.
   *   <li>Applies the command's logic to the aggregate.
   *   <li>Publishes the generated booking event(s).
   *   <li>Returns the result as a {@link BookingOutput}.
   * </ul>
   *
   * @param command The booking creation command.
   * @return A DTO representing the newly created booking.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  @Override
  public BookingOutput execute(CreateBookingCommand command) {
    var aggregate = bookingAggregateMapper.toAggregate(command);
    return handle(command, aggregate, bookingEventDispatcher, bookingOutputMapper);
  }
}

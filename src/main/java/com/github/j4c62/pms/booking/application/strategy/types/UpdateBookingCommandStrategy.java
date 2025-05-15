package com.github.j4c62.pms.booking.application.strategy.types;

import static com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate.restoreFrom;
import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.application.strategy.BookingCommandStrategy;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.types.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Command strategy for handling updates to existing bookings.
 *
 * <p>This class implements the {@link BookingCommandStrategy} interface specifically for {@link
 * UpdateBookingCommand} types. It is responsible for loading the current aggregate state, applying
 * the command to produce a new state (and domain events), publishing those events, and mapping the
 * updated state to an output DTO.
 *
 * <p>This component is typically used as part of a command handling framework or service layer that
 * delegates execution based on the command type.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-30
 */
@Component
@RequiredArgsConstructor
public class UpdateBookingCommandStrategy implements BookingCommandStrategy<UpdateBookingCommand> {
  private final BookingEventStore bookingEventStore;

  private final BookingEventPublisher bookingEventPublisher;
  private final BookingOutputMapper bookingOutputMapper;

  /**
   * Indicates whether this strategy supports the given command.
   *
   * @param command The command to check.
   * @return {@code true} if the command is an instance of {@code UpdateBookingCommand}, {@code
   *     false} otherwise.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  @Override
  public boolean supports(Command command) {
    return command instanceof UpdateBookingCommand;
  }

  /**
   * Executes the update command by.
   *
   * <ul>
   *   <li>Loading the event stream for the booking
   *   <li>Restoring the current aggregate state
   *   <li>Applying the command to mutate the aggregate
   *   <li>Publishing the resulting domain events
   *   <li>Mapping the updated aggregate to a {@link BookingOutput} DTO
   * </ul>
   *
   * @param command The command to execute.
   * @return The output representation of the updated booking.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-30
   */
  @Override
  public BookingOutput execute(UpdateBookingCommand command) {
    var events = bookingEventStore.getEventsForBooking(command.bookingId());
    var aggregate = restoreFrom(requireNonNull(events));
    var updatedAggregate = command.applyTo(aggregate);
    publishEvent(updatedAggregate);
    return bookingOutputMapper.toBookingOutput(updatedAggregate);
  }

  private void publishEvent(BookingAggregate aggregate) {
    aggregate.bookingEvents().events().forEach(bookingEventPublisher::publish);
  }
}

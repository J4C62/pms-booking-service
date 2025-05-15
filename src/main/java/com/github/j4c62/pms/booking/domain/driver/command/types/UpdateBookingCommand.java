package com.github.j4c62.pms.booking.domain.driver.command.types;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;

/**
 * Represents a command that modifies an existing {@link
 * com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate}.
 *
 * <p>All update commands must provide the {@link BookingId} of the booking they intend to modify.
 * These commands are typically translated into domain events that reflect updates to booking data,
 * such as changes to dates, status, or cancellation.
 *
 * <p>This interface extends {@link Command} to support polymorphic handling of booking update
 * operations.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-27
 */
public interface UpdateBookingCommand extends Command {
  /**
   * Returns the identifier of the booking to be updated.
   *
   * @return the {@link BookingId} of the target booking; never {@code null}
   * @author Jose Antonio (J4c62)
   * @since 2025-04-27
   */
  BookingId bookingId();
}

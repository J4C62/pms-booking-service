package com.github.j4c62.pms.booking.domain.driver.command.types;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static java.util.Objects.requireNonNull;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driver.command.Command;

/**
 * Command representing the creation of a new booking.
 *
 * <p>This command carries the initial data needed to create a booking, including the property,
 * guest, and booking dates. When applied, it produces a {@link
 * com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent} and uses it to
 * initialize a new {@link BookingAggregate}.
 *
 * @param propertyId The identifier of the property to be booked.
 * @param guestId The identifier of the guest making the booking.
 * @param bookingDates The dates of the booking (check-in and check-out).
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-17
 */
public record CreateBookingCommand(
    PropertyId propertyId, GuestId guestId, BookingDates bookingDates) implements Command {
  /**
   * Applies this command by creating and applying a {@link
   * com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent} to initialize a new
   * {@link BookingAggregate}.
   *
   * @param aggregate This parameter is ignored, as the booking does not yet exist.
   * @return A new {@code BookingAggregate} representing the newly created booking.
   * @since 2025-05-01
   */
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return createBookingEvent(requireNonNull(aggregate)).applyTo(null);
  }
}

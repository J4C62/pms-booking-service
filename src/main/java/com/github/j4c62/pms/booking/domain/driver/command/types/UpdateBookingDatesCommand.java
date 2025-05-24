package com.github.j4c62.pms.booking.domain.driver.command.types;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createUpdateBookingEvent;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;

/**
 * Command representing an update to the booking dates of an existing booking.
 *
 * <p>This command is part of the {@link UpdateBookingCommand} hierarchy and carries the new dates
 * to apply along with a reason for the update. When executed, it generates a {@link
 * com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent} and applies it to the
 * {@link BookingAggregate}.
 *
 * @param bookingId The identifier of the booking to be updated.
 * @param guestId The identifier of the actor responsible for the update.
 * @param bookingDates The new check-in and check-out dates for the booking.
 * @param updateReason A business-contextual reason for changing the booking dates.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-01
 */
public record UpdateBookingDatesCommand(
    BookingId bookingId, GuestId guestId, BookingDates bookingDates, String updateReason)
    implements UpdateBookingCommand {

  /**
   * Applies this command to a given {@link BookingAggregate} by generating a {@link
   * com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent} and applying it to
   * mutate the aggregate state.
   *
   * @param aggregate The current state of the booking aggregate.
   * @return A new {@code BookingAggregate} reflecting the updated dates.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-01
   */
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    var event = createUpdateBookingEvent(bookingId, bookingDates);
    return event.applyTo(aggregate);
  }
}

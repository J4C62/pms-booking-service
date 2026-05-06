package com.github.j4c62.pms.booking.domain.driver.command.types;

import static com.github.j4c62.pms.booking.domain.entity.creation.BookingEventFactory.createCancelledBookingEvent;

import com.github.j4c62.pms.booking.domain.entity.Booking;
import com.github.j4c62.pms.booking.domain.entity.vo.BookingId;
import com.github.j4c62.pms.booking.domain.entity.vo.GuestId;

/**
 * Command representing a request to cancel an existing booking.
 *
 * <p>This command is part of the booking modification command set and carries metadata about the
 * reason and the actor responsible for the cancellation. It produces a {@link
 * com.github.j4c62.pms.booking.domain.entity.event.BookingCancelledEvent} that is applied to the
 * {@link Booking}.
 *
 * @param bookingId The identifier of the booking to cancel.
 * @param guestId The identifier of the actor responsible for the cancellation.
 * @param reason The reason for the cancellation.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-17
 */
public record CancelBookingCommand(BookingId bookingId, GuestId guestId, String reason)
    implements UpdateBookingCommand {

  /**
   * Applies this command to a {@link Booking} by generating and applying a {@link
   * com.github.j4c62.pms.booking.domain.entity.event.BookingCancelledEvent}.
   *
   * @param aggregate The current state of the booking aggregate.
   * @return A new {@code BookingAggregate} with the cancellation applied.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-02
   */
  @Override
  public Booking applyTo(Booking aggregate) {
    var event = createCancelledBookingEvent(bookingId);
    return event.applyTo(aggregate);
  }
}

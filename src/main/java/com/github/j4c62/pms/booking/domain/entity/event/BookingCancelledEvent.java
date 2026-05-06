package com.github.j4c62.pms.booking.domain.entity.event;

import com.github.j4c62.pms.booking.domain.entity.Booking;
import com.github.j4c62.pms.booking.domain.entity.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.entity.vo.BookingId;
import java.time.Instant;

/**
 * Domain event representing the cancellation of a booking.
 *
 * <p>This event captures the intent and metadata of a booking being cancelled, including the
 * booking ID, the time the event occurred, and the event type.
 *
 * <p>Applying this event to a {@link Booking} transitions its state to "cancelled",
 * triggering any relevant side effects (e.g., publishing to other bounded contexts).
 *
 * @param bookingId The unique identifier of the cancelled booking.
 * @param occurredAt The timestamp when the cancellation occurred.
 * @param eventType The type of the event (typically {@code BOOKING_CANCELLED}).
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingCancelledEvent(
    BookingId bookingId, BookingEventType eventType, Instant occurredAt) implements BookingEvent {

  /**
   * Applies this event to the given {@link Booking}, marking it as cancelled.
   *
   * @param aggregate The current booking aggregate state.
   * @return A new {@link Booking} with updated status.
   * @throws IllegalStateException if the booking is already cancelled.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  @Override
  public Booking applyTo(Booking aggregate) {
    return aggregate.cancel();
  }
}

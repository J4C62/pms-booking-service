package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

/**
 * Domain event representing the cancellation of a booking.
 *
 * <p>This event captures the intent and metadata of a booking being cancelled, including the
 * booking ID, the time the event occurred, and the event type.
 *
 * <p>Applying this event to a {@link BookingAggregate} transitions its state to "cancelled",
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
    BookingId bookingId, Instant occurredAt, BookingEventType eventType) implements BookingEvent {

  /**
   * Applies this event to the given {@link BookingAggregate}, marking it as cancelled.
   *
   * @param aggregate The current booking aggregate state.
   * @return A new {@link BookingAggregate} with updated status.
   * @throws IllegalStateException if the booking is already cancelled.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.cancel();
  }
}

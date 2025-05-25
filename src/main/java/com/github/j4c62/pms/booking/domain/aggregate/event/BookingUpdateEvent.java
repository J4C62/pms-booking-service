package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

/**
 * Domain event representing an update to the booking dates.
 *
 * <p>This event indicates that the check-in and/or check-out dates of a booking have been modified.
 * It carries the new date information and metadata such as the time of occurrence and event type.
 *
 * <p>Applying this event to a {@link BookingAggregate} updates the aggregate’s booking dates and
 * validates the business rules associated with such a change.
 *
 * @param bookingId The ID of the booking being updated.
 * @param newDates The new booking dates (check-in and check-out).
 * @param occurredAt The timestamp when the event occurred.
 * @param eventType The event type, typically {@code BOOKING_UPDATED}.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingUpdateEvent(
    BookingId bookingId, BookingDates newDates, BookingEventType eventType, Instant occurredAt)
    implements BookingEvent {
  /**
   * Applies this update event to the given {@link BookingAggregate}, replacing the current booking
   * dates with {@code newDates}.
   *
   * @param aggregate The current booking aggregate state.
   * @return A new aggregate reflecting the updated dates.
   * @throws IllegalStateException if the booking is cancelled or if dates are unchanged.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.updateDates(newDates);
  }
}

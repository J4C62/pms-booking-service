package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

/**
 * Functional interface representing a read-only event store for booking-related events.
 *
 * <p>Provides access to the historical list of {@link
 * com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent} instances associated with a
 * specific {@link BookingId}. This is typically used to reconstruct the current state of a {@code
 * BookingAggregate} by replaying its event history.
 *
 * <p>This interface abstracts away the underlying storage mechanism, allowing different
 * implementations (e.g., in-memory, database, event log) to be used interchangeably.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-04
 */
@FunctionalInterface
public interface BookingEventStore {

  /**
   * Retrieves all {@link com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent}
   * instances associated with the given {@link BookingId}.
   *
   * @param bookingId the unique identifier of the booking
   * @return a {@link BookingEvents} container with the full event history of the booking; never
   *     {@code null}, but may be empty
   * @author Jose Antonio (J4c62)
   * @since 2025-05-04
   */
  BookingEvents getEventsForBooking(BookingId bookingId);
}

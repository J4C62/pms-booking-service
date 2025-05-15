package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

/**
 * Sealed interface representing a domain event in the Booking context.
 *
 * <p>A {@code BookingEvent} captures a state change or domain action applied to a {@link
 * BookingAggregate}, such as creation, cancellation, update, or confirmation of a booking.
 *
 * <p>Each implementation must provide the logic to apply the event to an aggregate and expose
 * relevant metadata such as the booking ID, event type, and occurrence timestamp.
 *
 * <p>This sealed interface restricts permitted event types to:
 *
 * <ul>
 *   <li>{@link BookingCreatedEvent}
 *   <li>{@link BookingCancelledEvent}
 *   <li>{@link BookingUpdateEvent}
 *   <li>{@link BookingConfirmedEvent}
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public sealed interface BookingEvent
    permits BookingCancelledEvent, BookingCreatedEvent, BookingUpdateEvent, BookingConfirmedEvent {
  /**
   * Returns the ID of the booking to which this event relates.
   *
   * @return the booking identifier.
   */
  BookingId bookingId();

  /**
   * Applies this event to the given {@link BookingAggregate}, producing an updated state.
   *
   * @param aggregate The current booking aggregate state.
   * @return A new aggregate reflecting this event.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  BookingAggregate applyTo(BookingAggregate aggregate);

  /**
   * Returns the type of this booking event.
   *
   * @return the event type.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-26
   */
  BookingEventType eventType();

  /**
   * Returns the timestamp when this event occurred.
   *
   * @return the time the event took place.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  Instant occurredAt();
}

package com.github.j4c62.pms.booking.domain.aggregate.event;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import java.time.Instant;
import java.util.List;

/**
 * Domain event representing the creation of a booking.
 *
 * <p>This event is used to initialize a {@link BookingAggregate} when a new booking is created. It
 * contains all necessary data to represent the initial state of the booking.
 *
 * @param bookingId The unique identifier of the booking.
 * @param propertyId The identifier of the property associated with the booking.
 * @param guestId The identifier of the guest who made the booking.
 * @param bookingDates The check-in and check-out dates for the booking.
 * @param occurredAt The timestamp indicating when the event occurred.
 * @param eventType The type of event, should be {@code BookingEventType.CREATED}.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingCreatedEvent(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    BookingEventType eventType,
    Instant occurredAt)
    implements BookingEvent {
  /**
   * Applies this event to create a new {@link BookingAggregate}.
   *
   * <p>This is the only event that can initialize a new aggregate instance. It sets the booking
   * status to {@code PENDING} and wraps this event in the event list.
   *
   * @param aggregate This parameter is ignored as this event creates a new aggregate.
   * @return A new {@code BookingAggregate} initialized from this event.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, bookingDates, PENDING, BookingEvents.of(List.of(this)));
  }
}

package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.time.Instant;

/**
 * Event representing that a booking has been confirmed.
 *
 * <p>This event is applied to a {@link BookingAggregate} to transition its status to confirmed.
 *
 * @param bookingId the unique identifier of the booking
 * @param eventType the type of booking event, expected to be {@link
 *     BookingEventType#BOOKING_CONFIRMED}
 * @param occurredAt the timestamp when the event occurred
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingConfirmedEvent(
    BookingId bookingId, BookingEventType eventType, Instant occurredAt) implements BookingEvent {

  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return aggregate.confirm();
  }
}

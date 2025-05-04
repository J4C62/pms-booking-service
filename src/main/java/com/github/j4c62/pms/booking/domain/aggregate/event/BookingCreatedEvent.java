package com.github.j4c62.pms.booking.domain.aggregate.event;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import java.time.Instant;
import java.util.List;

public record BookingCreatedEvent(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    Instant occurredAt,
    BookingEventType eventType)
    implements BookingEvent {

  @Override
  public BookingAggregate applyTo(BookingAggregate aggregate) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, bookingDates, PENDING, new BookingEvents(List.of(this)));
  }
}

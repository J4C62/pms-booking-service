package com.github.j4c62.pms.booking.domain.aggregate;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;

import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.util.List;

public record BookingAggregate(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    BookingStatus status,
    BookingEvents bookingEvents) {

  public BookingAggregate {
    bookingEvents = bookingEvents == null ? new BookingEvents(List.of()) : bookingEvents;
  }

  public static BookingAggregate restoreFrom(BookingEvents events) {
    if (events.events().isEmpty()) {
      throw new IllegalArgumentException("Cannot restore aggregate from empty event list");
    }

    var firstEvent = events.events().getFirst();
    if (!(firstEvent instanceof BookingCreatedEvent created)) {
      throw new IllegalStateException("First event must be BookingCreatedEvent");
    }

    var base =
        createBookingAggregate(
            created.bookingId(),
            created.propertyId(),
            created.guestId(),
            created.bookingDates(),
            BookingStatus.PENDING,
            new BookingEvents(List.of(created)));

    var tailEvents = new BookingEvents(events.events().subList(1, events.events().size()));
    return tailEvents.replayOn(base);
  }

  public BookingAggregate cancel() {
    if (status.isCancelled()) throw new IllegalStateException("Booking already cancelled");
    return withEvent(createBookingEvent(bookingId, null), BookingStatus.CANCELLED, bookingDates);
  }

  public BookingAggregate updateDates(BookingDates newDates) {
    validateUpdatable(newDates);
    return withEvent(createBookingEvent(bookingId, newDates), status, newDates);
  }

  private BookingAggregate withEvent(
      BookingEvent event, BookingStatus newStatus, BookingDates newDates) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, newDates, newStatus, bookingEvents.append(event));
  }

  private void validateUpdatable(BookingDates newDates) {
    if (status.isCancelled()) throw new IllegalStateException("Cannot update a cancelled booking");
    if (bookingDates.isSameAs(newDates))
      throw new IllegalStateException("No changes detected in booking dates");
  }
}

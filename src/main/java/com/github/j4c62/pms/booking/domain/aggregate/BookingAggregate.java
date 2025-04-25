package com.github.j4c62.pms.booking.domain.aggregate;

import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.snapshot.BookingSnapshot;
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

  public BookingAggregate cancel() {
    if (status.isCancelled()) throw new IllegalStateException("Booking already cancelled");
    return withEvent(
        new BookingCancelledEvent(bookingId, null), BookingStatus.CANCELLED, bookingDates);
  }

  public BookingAggregate updateDates(BookingDates newDates) {
    validateUpdatable(newDates);
    return withEvent(new BookingUpdateEvent(bookingId, newDates, null), status, newDates);
  }

  private BookingAggregate withEvent(
      BookingEvent event, BookingStatus newStatus, BookingDates newDates) {
    return new BookingAggregate(
        bookingId, propertyId, guestId, newDates, newStatus, bookingEvents.append(event));
  }

  private void validateUpdatable(BookingDates newDates) {
    if (status.isCancelled()) throw new IllegalStateException("Cannot update a cancelled booking");
    if (bookingDates.isSameAs(newDates))
      throw new IllegalStateException("No changes detected in booking dates");
  }

  public BookingSnapshot toSnapshot() {
    return new BookingSnapshot(bookingId, propertyId, guestId, bookingDates, status);
  }
}

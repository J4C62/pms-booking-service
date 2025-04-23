package com.github.j4c62.pms.booking.domain.aggregate;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.*;

import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.model.*;
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

  public BookingAggregate markAsPending() {
    return withEvent(
        new BookingCreatedEvent(bookingId, propertyId, guestId, bookingDates),
        BookingStatus.PENDING,
        bookingDates);
  }

  public BookingAggregate cancel() {
    if (status.isCancelled()) throw new IllegalStateException("Booking already cancelled");
    return withEvent(new BookingCancelledEvent(bookingId), BookingStatus.CANCELLED, bookingDates);
  }

  public BookingAggregate updateDates(BookingDates newDates) {
    validateUpdatable(newDates);
    return withEvent(new BookingUpdateEvent(bookingId, newDates), status, newDates);
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

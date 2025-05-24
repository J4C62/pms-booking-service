package com.github.j4c62.pms.booking.domain.aggregate;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createCancelledBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createConfirmedBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createUpdateBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CONFIRMED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import java.util.List;

/**
 * Represents the aggregate root for a booking in the domain model.
 *
 * <p>This class encapsulates the state and behavior of a booking, including operations such as
 * creation ,confirmation, cancellation, and date updates. It is designed to be restored from a
 * sequence of domain events (event sourcing pattern).
 *
 * @param bookingId The unique identifier of the booking.
 * @param propertyId The identifier of the property being booked.
 * @param guestId The identifier of the guest who made the booking.
 * @param bookingDates The dates associated with the booking (check-in, check-out).
 * @param status The current status of the booking (e.g., PENDING, CONFIRMED, CANCELLED).
 * @param bookingEvents The list of domain events related to the booking.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingAggregate(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    BookingStatus status,
    BookingEvents bookingEvents) {
  /**
   * Compact constructor that ensures {@code bookingEvents} is never {@code null}.
   *
   * <p>If {@code bookingEvents} is {@code null}, it will be initialized with an empty event list.
   * This guarantees safe access to {@code bookingEvents()} throughout the aggregate.
   *
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingAggregate {
    bookingEvents = bookingEvents == null ? BookingEvents.empty() : bookingEvents;
  }

  /**
   * Reconstructs a {@code BookingAggregate} from a list of domain events.
   *
   * @param events The list of events from which to restore the aggregate.
   * @return The reconstructed {@code BookingAggregate}.
   * @throws IllegalArgumentException if the event list is empty.
   * @throws IllegalStateException if the first event is not a {@code BookingCreatedEvent}.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-03
   */
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
            PENDING,
            BookingEvents.of(List.of(created)));

    var tailEvents = BookingEvents.of(events.events().subList(1, events.events().size()));
    return tailEvents.replayOn(base);
  }

  /**
   * Cancels the booking.
   *
   * @return A new {@code BookingAggregate} with updated status and cancellation event.
   * @throws IllegalStateException if the booking is already cancelled.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingAggregate cancel() {
    if (status.isCancelled()) {
      throw new IllegalStateException(
          "Booking with booking_id:%s is already cancelled".formatted(bookingId.value()));
    }
    return withEvent(createCancelledBookingEvent(bookingId), CANCELLED, bookingDates);
  }

  /**
   * Confirms the booking.
   *
   * @return A new {@code BookingAggregate} with updated status and confirmation event.
   * @throws IllegalStateException if the booking has already been cancelled.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public BookingAggregate confirm() {
    if (status.isCancelled()) {
      throw new IllegalStateException(
          "Booking with booking_id:%s is cancelled".formatted(bookingId.value()));
    }
    return withEvent(createConfirmedBookingEvent(bookingId), CONFIRMED, bookingDates);
  }

  /**
   * Updates the booking dates.
   *
   * @param newDates The new dates for the booking.
   * @return A new {@code BookingAggregate} with updated dates and event.
   * @throws IllegalStateException if the booking is cancelled or the dates have not changed.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingAggregate updateDates(BookingDates newDates) {
    validateUpdatable(newDates);
    return withEvent(createUpdateBookingEvent(bookingId, newDates), status, newDates);
  }

  private BookingAggregate withEvent(
      BookingEvent event, BookingStatus newStatus, BookingDates newDates) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, newDates, newStatus, BookingEvents.of(List.of(event)));
  }

  private void validateUpdatable(BookingDates newDates) {
    if (status.isCancelled()) {
      throw new IllegalStateException(
          "Booking with booking_id:%s is cancelled".formatted(bookingId.value()));
    }
    if (bookingDates.isSameAs(newDates)) {
      throw new IllegalStateException(
          "No changes detected in booking dates start_date:%s , end_date:%s"
              .formatted(bookingDates.startDate(), bookingDates.endDate()));
    }
  }
}

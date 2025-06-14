package com.github.j4c62.pms.booking.domain.aggregate.creation;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_CONFIRMED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_CREATED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType.BOOKING_UPDATED;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingConfirmedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import java.time.Instant;

/**
 * Factory class for creating instances of {@link BookingEvent}.
 *
 * <p>This class centralizes the creation of various booking-related domain events. It provides
 * convenience methods that encapsulate event creation logic and ensure proper event typing and
 * timestamping.
 *
 * <p>This class cannot be instantiated.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-01
 */
public final class BookingEventFactory {

  private BookingEventFactory() {}

  /**
   * Creates a {@link BookingUpdateEvent} representing a change in booking dates.
   *
   * @param bookingId The identifier of the booking being updated.
   * @param newDates The new booking dates to apply.
   * @return A {@code BookingUpdateEvent} with the current timestamp and {@code BOOKING_UPDATED}
   *     type.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-11
   */
  public static BookingEvent createUpdateBookingEvent(BookingId bookingId, BookingDates newDates) {
    return new BookingUpdateEvent(bookingId, newDates, BOOKING_UPDATED, Instant.now());
  }

  /**
   * Creates a {@link BookingCancelledEvent} representing the cancellation of a booking.
   *
   * @param bookingId The identifier of the booking being cancelled.
   * @return A {@code BookingCancelledEvent} with the current timestamp and {@code
   *     BOOKING_CANCELLED} type.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-11
   */
  public static BookingEvent createCancelledBookingEvent(BookingId bookingId) {
    return new BookingCancelledEvent(bookingId, BOOKING_CANCELLED, Instant.now());
  }

  /**
   * Creates a {@link BookingConfirmedEvent} representing the confirmation of a booking.
   *
   * @param bookingId The identifier of the booking being confirmed.
   * @return A {@code BookingConfirmedEvent} with the current timestamp and {@code
   *     BOOKING_CONFIRMED} type.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingEvent createConfirmedBookingEvent(BookingId bookingId) {
    return new BookingConfirmedEvent(bookingId, BOOKING_CONFIRMED, Instant.now());
  }

  /**
   * Creates a {@link BookingCreatedEvent} based on the current state of a {@link BookingAggregate}.
   *
   * @param aggregate The aggregate to extract data from for the event.
   * @return A {@code BookingCreatedEvent} with the current timestamp and {@code BOOKING_CREATED}
   *     type.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingEvent createBookingEvent(BookingAggregate aggregate) {
    return new BookingCreatedEvent(
        aggregate.bookingId(),
        aggregate.propertyId(),
        aggregate.guestId(),
        aggregate.bookingDates(),
        BOOKING_CREATED,
        Instant.now());
  }

  /**
   * Creates a {@link BookingCreatedEvent} with explicit values for all required properties.
   *
   * <p>This method is useful when constructing a creation event outside an aggregate context, such
   * as in DTO-to-domain mappings, test setups, or event replay scenarios. It ensures that the
   * created event has a valid structure and consistent metadata.
   *
   * @param bookingId The unique identifier of the booking.
   * @param propertyId The identifier of the property associated with the booking.
   * @param guestId The identifier of the guest who made the booking.
   * @param bookingDates The booking date range (start and end).
   * @return A {@code BookingCreatedEvent} instance with {@code BOOKING_CREATED} type and the
   *     current timestamp.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-25
   */
  public static BookingEvent createBookingEvent(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new BookingCreatedEvent(
        bookingId, propertyId, guestId, bookingDates, BOOKING_CREATED, Instant.now());
  }
}

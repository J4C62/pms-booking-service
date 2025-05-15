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
    return new BookingUpdateEvent(bookingId, newDates, Instant.now(), BOOKING_UPDATED);
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
    return new BookingCancelledEvent(bookingId, Instant.now(), BOOKING_CANCELLED);
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
        Instant.now(),
        BOOKING_CREATED);
  }
}

package com.github.j4c62.pms.booking.domain.aggregate.creation;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;

/**
 * Factory class for creating instances of {@link BookingAggregate}.
 *
 * <p>This class provides a centralized place for constructing {@code BookingAggregate} instances,
 * encapsulating the instantiation logic and ensuring consistency.
 *
 * <p>This class cannot be instantiated.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-01
 */
public final class BookingAggregateFactory {
  private BookingAggregateFactory() {}

  /**
   * Creates a new {@link BookingAggregate} with the provided parameters.
   *
   * @param bookingId The unique identifier of the booking.
   * @param propertyId The identifier of the property being booked.
   * @param guestId The identifier of the guest who made the booking.
   * @param bookingDates The dates associated with the booking.
   * @param status The current status of the booking.
   * @param bookingEvents The list of domain events associated with the booking.
   * @return A new instance of {@code BookingAggregate}.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-01
   */
  public static BookingAggregate createBookingAggregate(
      BookingId bookingId,
      PropertyId propertyId,
      GuestId guestId,
      BookingDates bookingDates,
      BookingStatus status,
      BookingEvents bookingEvents) {
    return new BookingAggregate(
        bookingId, propertyId, guestId, bookingDates, status, bookingEvents);
  }
}

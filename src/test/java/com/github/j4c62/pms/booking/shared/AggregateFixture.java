package com.github.j4c62.pms.booking.shared;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createCancelledBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createConfirmedBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createUpdateBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Test configuration fixture providing test data and mock aggregates for booking operations.
 *
 * <p>This class defines beans used in integration or unit tests to simulate a consistent and
 * reusable booking context, including identifiers, domain objects, and events.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
@TestConfiguration
public class AggregateFixture {
  /**
   * Provides a random {@link BookingId} for testing purposes.
   *
   * @return a new {@link BookingId}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public BookingId bookingId() {
    return BookingId.of(UUID.randomUUID());
  }

  /**
   * Provides a random {@link PropertyId} for testing purposes.
   *
   * @return a new {@link PropertyId}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public PropertyId propertyId() {
    return PropertyId.of(UUID.randomUUID());
  }

  /**
   * Provides a random {@link GuestId} for testing purposes.
   *
   * @return a new {@link GuestId}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public GuestId guestId() {
    return GuestId.of(UUID.randomUUID());
  }

  /**
   * Provides a default {@link BookingDates} object starting today and ending two days later.
   *
   * @return a new {@link BookingDates}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public BookingDates bookingDates() {
    return BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
  }

  /**
   * Provides a {@link BookingCreatedEvent} used to simulate a booking creation.
   *
   * @return a {@link BookingEvent} instance with type {@code BOOKING_CREATED}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("bookingCreatedEvent")
  public BookingEvent bookingCreatedEvent(
      BookingId bookingId, PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return createBookingEvent(bookingId, propertyId, guestId, bookingDates);
  }

  /**
   * Provides a {@link com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent} to
   * simulate a cancellation.
   *
   * @return a {@link BookingEvent} instance with type {@code BOOKING_CANCELLED}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("bookingCancelledEvent")
  public BookingEvent bookingCancelledEvent(BookingId bookingId) {
    return createCancelledBookingEvent(bookingId);
  }

  /**
   * Provides a {@link com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent} to
   * simulate a booking update.
   *
   * @return a {@link BookingEvent} instance with type {@code BOOKING_UPDATED}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("bookingUpdateEvent")
  public BookingEvent bookingUpdateEvent(BookingId bookingId, BookingDates bookingDates) {
    return createUpdateBookingEvent(bookingId, bookingDates);
  }

  /**
   * Provides a {@link com.github.j4c62.pms.booking.domain.aggregate.event.BookingConfirmedEvent} to
   * simulate a booking confirmation.
   *
   * @return a {@link BookingEvent} instance with type {@code BOOKING_CONFIRMED}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @Qualifier("bookingConfirmedEvent")
  public BookingEvent bookingConfirmedEvent(BookingId bookingId) {
    return createConfirmedBookingEvent(bookingId);
  }

  /**
   * Aggregates booking events into a {@link BookingEvents} container.
   *
   * @param createdEvent the initial booking event
   * @return a {@link BookingEvents} object containing the created event
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public BookingEvents bookingEvents(@Qualifier("bookingCreatedEvent") BookingEvent createdEvent) {
    return BookingEvents.of(List.of(createdEvent));
  }

  /**
   * Provides a fully constructed {@link BookingAggregate} with initial state {@code PENDING}.
   *
   * @return a {@link BookingAggregate} instance
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  public BookingAggregate bookingAggregate(
      BookingId bookingId,
      PropertyId propertyId,
      GuestId guestId,
      BookingDates bookingDates,
      BookingEvents bookingEvents) {
    return createBookingAggregate(
        bookingId, propertyId, guestId, bookingDates, PENDING, bookingEvents);
  }
}

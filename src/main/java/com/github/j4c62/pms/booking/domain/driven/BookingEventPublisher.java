package com.github.j4c62.pms.booking.domain.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;

/**
 * Functional interface responsible for publishing {@link BookingEvent} instances.
 *
 * <p>Implementations of this interface handle the dispatching of booking-related events to
 * downstream systems, such as message brokers, event logs, or other services.
 *
 * <p>This interface is typically used to decouple the domain logic from infrastructure concerns.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-17
 */
@FunctionalInterface
public interface BookingEventPublisher {
  /**
   * Publishes the given {@link BookingEvent} to the appropriate channel.
   *
   * @param bookingEvent the event to be published; must not be {@code null}
   * @author Jose Antonio (J4c62)
   * @since 2025-04-24
   */
  void publish(BookingEvent bookingEvent);
}

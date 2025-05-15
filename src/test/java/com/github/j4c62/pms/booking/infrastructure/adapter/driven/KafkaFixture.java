package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Test configuration for Kafka-based integration testing.
 *
 * <p>This fixture sets up required beans for Kafka tests, including Jackson serialization support
 * and domain-specific aggregates from {@link AggregateFixture}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
@TestConfiguration
@Import({JacksonAutoConfiguration.class, AggregateFixture.class})
public class KafkaFixture {
  /**
   * Test component that groups together booking event fixtures for use in Kafka integration tests.
   *
   * <p>Beans are qualified to resolve multiple {@link BookingEvent} instances in the test context.
   *
   * @param createBookingEvent the booking created event
   * @param updateBookingEvent the booking updated event
   * @param cancelBookingEvent the booking cancelled event
   * @author Jose Antonio (J4c62)
   * @version 1.0.0
   * @since 2025-05-10
   */
  @TestComponent
  public record SetUpFixtureIntegration(
      @Qualifier("bookingCreatedEvent") BookingEvent createBookingEvent,
      @Qualifier("bookingUpdateEvent") BookingEvent updateBookingEvent,
      @Qualifier("bookingCancelledEvent") BookingEvent cancelBookingEvent) {}
}

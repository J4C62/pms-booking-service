package com.github.j4c62.pms.booking.shared;

import static org.mockito.Mockito.mock;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Test configuration for injecting mock implementations of driven adapter interfaces.
 *
 * <p>This configuration is used during testing to provide fake or mocked versions of core
 * infrastructure interfaces such as {@link BookingEventPublisher} and {@link BookingEventStore}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-10
 */
@TestConfiguration
@Import(AggregateFixture.class)
public class DrivenFixture {
  /**
   * Provides a mocked implementation of {@link BookingEventPublisher} if one is not already defined
   * in the Spring context.
   *
   * @return a mock of {@link BookingEventPublisher}
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @ConditionalOnMissingBean(BookingEventPublisher.class)
  public BookingEventPublisher bookingEventPublisher() {
    return mock(BookingEventPublisher.class);
  }

  /**
   * Provides a simple in-memory implementation of {@link BookingEventStore} based on the provided
   * {@link BookingEvents}. Filters and returns events that match the requested {@link
   * com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId}.
   *
   * @param bookingEvents a collection of all available booking events
   * @return a filtered {@link BookingEventStore} implementation
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  @Bean
  @ConditionalOnMissingBean(BookingEventStore.class)
  public BookingEventStore bookingEventStore(BookingEvents bookingEvents) {
    return bookingId ->
        BookingEvents.of(
            bookingEvents.events().stream()
                .filter(bookingEvent -> bookingEvent.bookingId().equals(bookingId))
                .toList());
  }
}

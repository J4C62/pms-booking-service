package com.github.j4c62.pms.booking.shared;

import static org.mockito.Mockito.mock;

import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(AggregateFixture.class)
public class DrivenFixture {

  @Bean
  @ConditionalOnMissingBean(BookingEventPublisher.class)
  public BookingEventPublisher bookingEventPublisher() {
    return mock(BookingEventPublisher.class);
  }

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

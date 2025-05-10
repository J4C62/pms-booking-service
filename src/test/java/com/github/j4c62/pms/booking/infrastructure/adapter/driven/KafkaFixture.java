package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import static org.mockito.Mockito.mock;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.shared.assembler.CloudEventAssembler;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

@TestConfiguration
@Import({
  KafkaStreamsStoreBooking.class,
  KafkaProducerAdapter.class,
  CloudEventAssembler.class,
  JacksonAutoConfiguration.class,
  AggregateFixture.class
})
public class KafkaFixture {

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_BUILDER_BEAN_NAME)
  public StreamsBuilderFactoryBean defaultKafkaStreamsBuilder() {
    return mock(StreamsBuilderFactoryBean.class);
  }

  @TestComponent
  public record SetUpFixtureIntegration(
      BookingEventPublisher bookingEventPublisher,
      StreamsBuilderFactoryBean streamsBuilderFactoryBean,
      @Qualifier("bookingCreatedEvent") BookingEvent createBookingEvent,
      @Qualifier("bookingUpdateEvent") BookingEvent updateBookingEvent,
      @Qualifier("bookingCancelledEvent") BookingEvent cancelBookingEvent) {}
}

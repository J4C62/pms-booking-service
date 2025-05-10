package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(KafkaFixture.class)
class KafkaStreamsStoreTest {
  @Autowired KafkaStreamsStoreBooking kafkaStreamsStore;
  @Autowired KafkaFixture.SetUpFixtureIntegration setUpFixtureIntegration;
  @MockitoBean KafkaStreams kafkaStreams;
  @MockitoBean ReadOnlyKeyValueStore<BookingId, BookingEvents> keyValueStore;
  @MockitoBean private KafkaTemplate<String, Object> kafkaTemplate;

  @Test
  void givenValidBookingIdWhenGetEventsForBookingThenReturnsBookingEvents(
      @Autowired BookingId bookingId, @Autowired BookingEvents expectedEvents) {

    when(setUpFixtureIntegration.streamsBuilderFactoryBean().getKafkaStreams())
        .thenReturn(kafkaStreams);
    when(kafkaStreams.store(any(StoreQueryParameters.class))).thenReturn(keyValueStore);
    when(keyValueStore.get(bookingId)).thenReturn(expectedEvents);

    var result = kafkaStreamsStore.getEventsForBooking(bookingId);

    assertThat(result).isEqualTo(expectedEvents);
    verify(keyValueStore).get(bookingId);
  }

  @Test
  void givenNoKafkaStreamsInstanceWhenGetEventsForBookingThenThrowsNPE(
      @Autowired BookingId bookingId) {
    when(setUpFixtureIntegration.streamsBuilderFactoryBean().getKafkaStreams()).thenReturn(null);
    assertThatThrownBy(() -> kafkaStreamsStore.getEventsForBooking(bookingId))
        .isInstanceOf(NullPointerException.class);
  }
}

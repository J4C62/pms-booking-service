package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.util.List;
import java.util.UUID;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

@ExtendWith(MockitoExtension.class)
class KafkaStreamsStoreTest {

  @Mock StreamsBuilderFactoryBean streamsBuilderFactoryBean;
  @Mock KafkaStreams kafkaStreams;
  @Mock ReadOnlyKeyValueStore<BookingId, BookingEvents> keyValueStore;

  @InjectMocks KafkaStreamsStore kafkaStreamsStore;

  @Test
  void givenValidBookingIdWhenGetEventsForBookingThenReturnsBookingEvents() {
    var bookingId = new BookingId(UUID.randomUUID());
    var expectedEvents = new BookingEvents(List.of(createBookingEvent(bookingId)));

    when(streamsBuilderFactoryBean.getKafkaStreams()).thenReturn(kafkaStreams);
    when(kafkaStreams.store(any(StoreQueryParameters.class))).thenReturn(keyValueStore);
    when(keyValueStore.get(bookingId)).thenReturn(expectedEvents);

    BookingEvents result = kafkaStreamsStore.getEventsForBooking(bookingId);

    assertThat(result).isEqualTo(expectedEvents);
    verify(keyValueStore).get(bookingId);
  }

  @Test
  void givenNoKafkaStreamsInstanceWhenGetEventsForBookingThenThrowsNPE() {
    var bookingId = new BookingId(UUID.randomUUID());

    when(streamsBuilderFactoryBean.getKafkaStreams()).thenReturn(null);

    assertThatThrownBy(() -> kafkaStreamsStore.getEventsForBooking(bookingId))
        .isInstanceOf(NullPointerException.class);
  }
}

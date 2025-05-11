package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableKafkaStreams
public class KafkaStreamsStoreBooking implements BookingEventStore {

  private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

  @Value("${application.booking.kafka.store-name}")
  String storeName;

  @Override
  public BookingEvents getEventsForBooking(BookingId bookingId) {
    ReadOnlyKeyValueStore<BookingId, BookingEvents> eventStore =
        Objects.requireNonNull(streamsBuilderFactoryBean.getKafkaStreams())
            .store(
                StoreQueryParameters.fromNameAndType(
                    storeName, QueryableStoreTypes.keyValueStore()));
    return eventStore.get(bookingId);
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaStreamsStoreBooking implements BookingEventStore {

  private final InteractiveQueryService queryService;

  @Value("${application.booking.kafka.store-name}")
  private String storeName;

  @Override
  public BookingEvents getEventsForBooking(BookingId bookingId) {
    ReadOnlyKeyValueStore<BookingId, BookingEvents> store =
        queryService.getQueryableStore(storeName, QueryableStoreTypes.keyValueStore());
    return store.get(bookingId);
  }
}

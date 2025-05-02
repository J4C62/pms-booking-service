package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableKafkaStreams
public class KafkaStreamsStore implements EventStore {

  private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

  @Override
  public BookingEvents getEventsForBooking(BookingId bookingId) {
    // Obtener el store de eventos
    ReadOnlyKeyValueStore<String, BookingEvents> eventStore =
        Objects.requireNonNull(streamsBuilderFactoryBean.getKafkaStreams())
            .store(
                StoreQueryParameters.fromNameAndType(
                    "booking-events-store", QueryableStoreTypes.keyValueStore()));

    List<BookingEvents> allEvents = new ArrayList<>();
    KeyValueIterator<String, BookingEvents> iterator = eventStore.all();

    while (iterator.hasNext()) {
      KeyValue<String, BookingEvents> entry = iterator.next();
      allEvents.add(entry.value);
      System.out.println(entry.key);
    }
    iterator.close();
    System.out.println(allEvents);
    return null;
  }
}

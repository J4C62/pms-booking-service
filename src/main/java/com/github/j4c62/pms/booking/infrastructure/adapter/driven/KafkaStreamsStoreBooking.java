package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Component;

/**
 * Kafka Streams-based implementation of the {@link BookingEventStore} interface.
 *
 * <p>This component retrieves stored {@link BookingEvents} for a specific {@link BookingId} from a
 * Kafka Streams state store using the {@link InteractiveQueryService}.
 *
 * <p>The store name is configurable via the property <code>application.booking.kafka.store-name
 * </code>.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-02
 */
@Component
@RequiredArgsConstructor
public class KafkaStreamsStoreBooking implements BookingEventStore {

  private final InteractiveQueryService queryService;

  @Value("${application.booking.kafka.store-name}")
  private String storeName;

  /**
   * Retrieves the list of {@link com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent}s
   * associated with the given {@link BookingId} from the Kafka Streams state store.
   *
   * @param bookingId the identifier of the booking whose events are to be retrieved; must not be
   *     {@code null}
   * @return the {@link BookingEvents} associated with the booking, or {@code null} if not found
   * @author Jose Antonio (J4c62)
   * @since 2025-05-02
   */
  @Override
  @NonNull
  public BookingEvents getEventsForBooking(@NonNull BookingId bookingId) {
    ReadOnlyKeyValueStore<BookingId, BookingEvents> store =
        queryService.getQueryableStore(storeName, QueryableStoreTypes.keyValueStore());
    return store.get(bookingId);
  }
}

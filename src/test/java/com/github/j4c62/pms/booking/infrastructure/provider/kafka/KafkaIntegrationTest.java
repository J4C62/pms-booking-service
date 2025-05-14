package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@EnableKafka
@EmbeddedKafka(
    partitions = 1,
    topics = {"booking.created", "booking.updated", "booking.cancelled", "booking.confirmed"})
@TestPropertySource(
    properties = {
      "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.application-id=booking-service",
      "spring.kafka.streams.state-dir: ${java.io.tmpdir}/kafka-streams-integration-test",
      "grpc.server.port=-1",
      "application.booking.kafka.store-name=kafka-streams-integration-test"
    })
@Import(AggregateFixture.class)
class KafkaIntegrationTest {
  @Value("${application.booking.kafka.store-name}")
  String storeName;

  @Autowired private StreamBridge streamBridge;
  @Autowired private InteractiveQueryService queryService;
  @Autowired private StreamsBuilderFactoryBean streamsBuilderFactoryBean;

  @Test
  void givenBookingEventsWhenProducedThenShouldBeConsumedSuccessfully(
      @Autowired @Qualifier("bookingCreatedEvent") BookingEvent bookingCreatedEvent,
      @Autowired @Qualifier("bookingUpdateEvent") BookingEvent bookingUpdatedEvent,
      @Autowired @Qualifier("bookingCancelledEvent") BookingEvent bookingCancelledEvent,
      @Autowired @Qualifier("bookingConfirmedEvent") BookingEvent bookingConfirmedEvent) {
    await()
        .atMost(Duration.ofSeconds(30))
        .untilAsserted(
            () ->
                assertThat(requireNonNull(streamsBuilderFactoryBean.getKafkaStreams()).state())
                    .isEqualTo(KafkaStreams.State.RUNNING));

    streamBridge.send("bookingEventSupplier-out-0", bookingCreatedEvent);
    streamBridge.send("bookingEventSupplier-out-0", bookingUpdatedEvent);
    streamBridge.send("bookingEventSupplier-out-0", bookingCancelledEvent);
    streamBridge.send("bookingEventSupplier-out-0", bookingConfirmedEvent);

    await()
        .atMost(Duration.ofSeconds(20))
        .untilAsserted(() -> assertThat(getStoredEvents()).hasSizeGreaterThan(0));
  }

  public List<String> getStoredEvents() {
    ReadOnlyKeyValueStore<BookingId, BookingEvents> store =
        queryService.getQueryableStore(storeName, QueryableStoreTypes.keyValueStore());

    try (var iterator = store.all()) {
      List<String> results = new ArrayList<>();
      while (iterator.hasNext()) {
        var kv = iterator.next();
        results.add(kv.value.toString());
      }
      return results;
    }
  }
}

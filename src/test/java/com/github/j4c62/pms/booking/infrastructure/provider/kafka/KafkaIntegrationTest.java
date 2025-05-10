package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.infrastructure.adapter.driven.assembler.CloudEventAssembler;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import io.cloudevents.kafka.CloudEventDeserializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.FileSystemUtils;

@SpringBootTest
@EnableKafka
@EmbeddedKafka(
    partitions = 1,
    topics = {"booking.created", "booking.updated", "booking.cancelled"})
@TestPropertySource(
    properties = {
      "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.application-id=booking-service",
      "spring.kafka.streams.state-dir: ${java.io.tmpdir}/kafka-streams-test",
      "grpc.server.port=-1"
    })
@Import(AggregateFixture.class)
class KafkaIntegrationTest {
  @Autowired EmbeddedKafkaBroker embeddedKafkaBroker;
  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;
  private KafkaConsumer<String, String> consumer;

  @Autowired private StreamsBuilderFactoryBean streamsBuilderFactoryBean;
  @Autowired private CloudEventAssembler cloudEventAssembler;

  @BeforeEach
  void setUp() {
    var consumerProps =
        KafkaTestUtils.consumerProps("hotel-pms-group", "false", embeddedKafkaBroker);

    consumerProps.put(
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, CloudEventDeserializer.class.getName());
    consumerProps.put(
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

    consumer = new KafkaConsumer<>(consumerProps);
    consumer.subscribe(List.of("booking.created", "booking.updated", "booking.cancelled"));

    streamsBuilderFactoryBean.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    if (consumer != null) {
      consumer.close();
    }
    if (streamsBuilderFactoryBean.getKafkaStreams() != null) {
      streamsBuilderFactoryBean.getKafkaStreams().close();
    }
    Path stateDir =
        Paths.get(System.getProperty("java.io.tmpdir"), "kafka-streams-test", "booking-service");
    if (Files.exists(stateDir)) {
      FileSystemUtils.deleteRecursively(stateDir);
    }
  }

  @Test
  void givenBookingEventsWhenProducedThenShouldBeConsumedSuccessfully(
      @Autowired @Qualifier("bookingCreatedEvent") BookingEvent bookingCreatedEvent,
      @Autowired @Qualifier("bookingUpdateEvent") BookingEvent bookingUpdatedEvent,
      @Autowired @Qualifier("bookingCancelledEvent") BookingEvent bookingCancelledEvent) {

    var cloudEventCreated = cloudEventAssembler.toCloudEvent(bookingCreatedEvent);
    var cloudEventUpdated = cloudEventAssembler.toCloudEvent(bookingUpdatedEvent);
    var cloudEventCancelled = cloudEventAssembler.toCloudEvent(bookingCancelledEvent);

    kafkaTemplate.send("booking.created", cloudEventCreated);
    kafkaTemplate.send("booking.updated", cloudEventUpdated);
    kafkaTemplate.send("booking.cancelled", cloudEventCancelled);

    var records = KafkaTestUtils.getRecords(consumer);

    assertThat(records.count()).isEqualTo(3);
    consumer.close();

    await()
        .atMost(Duration.ofSeconds(20))
        .untilAsserted(() -> assertThat(getStoreCount()).hasSize(1));
  }

  private List<String> getStoreCount() {
    var outputEvents =
        Objects.requireNonNull(streamsBuilderFactoryBean.getKafkaStreams())
            .store(
                StoreQueryParameters.fromNameAndType(
                    "booking-events-store", QueryableStoreTypes.keyValueStore()))
            .all();
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(outputEvents, 0), false)
        .map(objectObjectKeyValue -> objectObjectKeyValue.value.toString())
        .toList();
  }
}

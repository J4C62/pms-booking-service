package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.CloudEventAssembler;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Spliterators;
import java.util.UUID;
import java.util.stream.StreamSupport;

import io.cloudevents.kafka.CloudEventDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@EnableKafka
@EmbeddedKafka(
    partitions = 1,
    topics = {"booking.created", "booking.updated", "booking.cancelled"})
@TestPropertySource(
    properties = {
      "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.bootstrap-servers=${spring.embedded.kafka.brokers}",
      "spring.kafka.streams.application-id=booking-service"
    })
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
  void tearDown() {
    if (consumer != null) {
      consumer.close();
    }
    if (streamsBuilderFactoryBean.getKafkaStreams() != null) {
      streamsBuilderFactoryBean.getKafkaStreams().close();
    }
  }

  @Test
  void givenBookingEventsWhenProducedThenShouldBeConsumedSuccessfully() {
    var cloudEventCreated =
        cloudEventAssembler.toCloudEvent(
            new BookingCreatedEvent(
                new BookingId(UUID.randomUUID()),
                new PropertyId(UUID.randomUUID()),
                new GuestId(UUID.randomUUID()),
                new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
                Instant.now(),
                BookingEventType.BOOKING_CREATED));
    var cloudEventUpdated =
        cloudEventAssembler.toCloudEvent(
            createBookingEvent(
                new BookingId(UUID.randomUUID()),
                new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2))));

    var cloudEventCancelled =
        cloudEventAssembler.toCloudEvent(createBookingEvent(new BookingId(UUID.randomUUID())));
    kafkaTemplate.send("booking.created", cloudEventCreated);
    kafkaTemplate.send("booking.updated", cloudEventUpdated);
    kafkaTemplate.send("booking.cancelled", cloudEventCancelled);

    var records = KafkaTestUtils.getRecords(consumer);

    assertThat(records.count()).isEqualTo(3);
    consumer.close();
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

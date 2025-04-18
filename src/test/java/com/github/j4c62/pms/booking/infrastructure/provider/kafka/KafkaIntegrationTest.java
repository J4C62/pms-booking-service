package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.net.URI;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@EnableKafka
@SpringBootTest
@EmbeddedKafka(
    partitions = 1,
    topics = {"booking.created", "booking.updated", "booking.cancelled"})
class KafkaIntegrationTest {
  @Autowired EmbeddedKafkaBroker embeddedKafkaBroker;
  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;
  private KafkaConsumer<String, String> consumer;

  @BeforeEach
  void setUp() {
    var consumerProps =
        KafkaTestUtils.consumerProps("hotel-pms-group", "false", embeddedKafkaBroker);
    consumerProps.put(
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    consumerProps.put(
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

    consumer = new KafkaConsumer<>(consumerProps);
    consumer.subscribe(List.of("booking.created", "booking.updated", "booking.cancelled"));
  }

  @Test
  void sendEvent() {
    var eventTemplate =
        io.cloudevents.core.builder.CloudEventBuilder.v1()
            .withSource(URI.create("service://booking-service"))
            .withType("booking.created");

    var event =
        eventTemplate
            .newBuilder()
            .withId("id")
            .withDataContentType("application/json")
            .withData("{\"message\":\"ping\"}".getBytes())
            .build();

    kafkaTemplate.send("booking.created", event);
    kafkaTemplate.send("booking.updated", event);
    kafkaTemplate.send("booking.cancelled", event);

    var records = KafkaTestUtils.getRecords(consumer);

    assertThat(records.count()).isEqualTo(3);
    assertThat(records.iterator().next().value()).contains("ping");

    consumer.close();
  }
}

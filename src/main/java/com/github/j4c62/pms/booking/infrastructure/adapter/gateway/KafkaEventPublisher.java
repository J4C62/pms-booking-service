package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventPublisher implements BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final ObjectMapper objectMapper;

  @Override
  public void publishBookingCreated(BookingCreated bookingCreated) {

    var eventTemplate =
        io.cloudevents.core.builder.CloudEventBuilder.v1()
            .withSource(URI.create("service://booking-service"))
            .withType("booking.created");

    var event =
        eventTemplate
            .newBuilder()
            .withId(bookingCreated.bookingId())
            .withDataContentType("application/json")
            .withData(toJsonString(bookingCreated).getBytes(StandardCharsets.UTF_8))
            .build();

    kafkaTemplate.send(
        new ProducerRecord<>("booking.created", UUID.randomUUID().toString(), event));
  }

  @SneakyThrows
  private String toJsonString(BookingCreated bookingCreated) {
    return objectMapper.writeValueAsString(bookingCreated);
  }

  @Override
  public void publishBookingUpdated(BookingUpdated bookingUpdated) {}

  @Override
  public void publishBookingCancelled(BookingCancelled bookingCancelled) {}
}

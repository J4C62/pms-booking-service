package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CloudEventAssembler {

  private final ObjectMapper objectMapper;

  @SneakyThrows
  public CloudEvent toCloudEvent(Object bookingEvent, BookingEventType eventType) {
    var eventTemplate =
        io.cloudevents.core.builder.CloudEventBuilder.v1()
            .withSource(URI.create("service://booking-service"))
            .withType(eventType.getEventType());

    return eventTemplate
        .newBuilder()
        .withId(UUID.randomUUID().toString())
        .withDataContentType("application/json")
        .withData(toJsonString(bookingEvent).getBytes(StandardCharsets.UTF_8))
        .build();
  }

  private String toJsonString(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}

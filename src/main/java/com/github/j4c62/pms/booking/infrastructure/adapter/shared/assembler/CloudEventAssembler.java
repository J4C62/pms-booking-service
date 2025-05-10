package com.github.j4c62.pms.booking.infrastructure.adapter.shared.assembler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import io.cloudevents.CloudEvent;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CloudEventAssembler {

  private final ObjectMapper objectMapper;

  public CloudEvent toCloudEvent(BookingEvent bookingEvent) {
    var eventTemplate =
        io.cloudevents.core.builder.CloudEventBuilder.v1()
            .withSource(URI.create("service://booking-service"))
            .withType(bookingEvent.eventType().getEventType());

    return eventTemplate
        .newBuilder()
        .withId(UUID.randomUUID().toString())
        .withDataContentType("application/json")
        .withData(toJsonString(bookingEvent).getBytes(StandardCharsets.UTF_8))
        .build();
  }

  @Generated
  private String toJsonString(BookingEvent bookingEvent) {
    try {
      return objectMapper.writeValueAsString(bookingEvent);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(
          "Failed to serialize booking event: %s".formatted(bookingEvent.getClass()), e);
    }
  }
}

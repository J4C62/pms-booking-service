package com.github.j4c62.pms.booking.infrastructure.provider.kafka.deserializer;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.infrastructure.provider.kafka.resolver.BookingEventTypeResolver;
import io.cloudevents.CloudEvent;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingEventDeserializer {

  private final ObjectMapper mapper;
  private final BookingEventTypeResolver resolver;

  public BookingEvent deserialize(CloudEvent cloudEvent) {
    try {
      var json = new String(requireNonNull(cloudEvent.getData()).toBytes(), StandardCharsets.UTF_8);
      var eventClass = resolver.resolve(cloudEvent.getType());
      return mapper.readValue(json, eventClass);
    } catch (Exception e) {
      throw new SerializationException("Failed to deserialize BookingEvent", e);
    }
  }
}

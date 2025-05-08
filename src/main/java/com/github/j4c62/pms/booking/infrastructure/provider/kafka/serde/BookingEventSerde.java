package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

@RequiredArgsConstructor
public class BookingEventSerde implements Serde<BookingEvent> {

  private final ObjectMapper mapper;

  private static Class<? extends Record> resolveType(String type) {
    return switch (type) {
      case "BOOKING_CREATED" -> BookingCreatedEvent.class;
      case "BOOKING_CANCELLED" -> BookingCancelledEvent.class;
      case "BOOKING_UPDATED" -> BookingUpdateEvent.class;
      default -> throw new IllegalArgumentException("Unknown eventType: %s".formatted(type));
    };
  }

  @Override
  public Serializer<BookingEvent> serializer() {
    return (topic, data) -> {
      try {
        return mapper.writeValueAsBytes(data);
      } catch (Exception e) {
        throw new SerializationException("Error serializing BookingEvent", e);
      }
    };
  }

  @Override
  public Deserializer<BookingEvent> deserializer() {
    return (topic, bytes) -> {
      try {
        var node = mapper.readTree(bytes);
        var type = node.get("eventType").asText();
        return (BookingEvent) mapper.treeToValue(node, resolveType(type));
      } catch (Exception e) {
        throw new SerializationException("Error deserializing BookingEvent", e);
      }
    };
  }
}

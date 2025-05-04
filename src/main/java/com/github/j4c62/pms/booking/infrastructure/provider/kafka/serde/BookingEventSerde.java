package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class BookingEventSerde implements Serde<BookingEvent> {

  private final ObjectMapper mapper;

  public BookingEventSerde() {
    this.mapper = new ObjectMapper();
    this.mapper.registerModule(new JavaTimeModule());
  }

  @Override
  public Serializer<BookingEvent> serializer() {
    return (topic, data) -> {
      try {
        return mapper.writeValueAsBytes(data);
      } catch (Exception e) {
        throw new RuntimeException("Serialization error", e);
      }
    };
  }

  @Override
  public Deserializer<BookingEvent> deserializer() {
    return (topic, bytes) -> {
      try {
        JsonNode node = mapper.readTree(bytes);
        String type = node.get("eventType").asText();

        Class<? extends BookingEvent> clazz =
            switch (type) {
              case "BOOKING_CREATED" -> BookingCreatedEvent.class;
              case "BOOKING_CANCELLED" -> BookingCancelledEvent.class;
              case "BOOKING_UPDATED" -> BookingUpdateEvent.class;
              default -> throw new IllegalArgumentException("Unknown eventType: " + type);
            };

        return mapper.treeToValue(node, clazz);

      } catch (Exception e) {
        throw new RuntimeException("Deserialization error", e);
      }
    };
  }
}

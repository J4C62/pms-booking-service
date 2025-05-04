package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class BookingEventsSerde implements Serde<BookingEvents> {

  private final ObjectMapper mapper;

  public BookingEventsSerde() {
    this.mapper = new ObjectMapper();
    this.mapper.registerModule(new JavaTimeModule());
  }

  @Override
  public Serializer<BookingEvents> serializer() {
    return (topic, data) -> {
      try {
        return mapper.writeValueAsBytes(data.events());
      } catch (Exception e) {
        throw new SerializationException("Error serializing BookingEvents", e);
      }
    };
  }

  @Override
  public Deserializer<BookingEvents> deserializer() {
    return (topic, bytes) -> {
      try {
        JsonNode root = mapper.readTree(bytes);
        List<BookingEvent> events = new ArrayList<>();

        for (JsonNode node : root) {
          String eventType = node.get("eventType").asText();
          Class<? extends BookingEvent> clazz = resolveType(eventType);
          BookingEvent event = mapper.treeToValue(node, clazz);
          events.add(event);
        }

        return new BookingEvents(events);
      } catch (Exception e) {
        throw new SerializationException("Error deserializing BookingEvents", e);
      }
    };
  }

  private Class<? extends BookingEvent> resolveType(String eventType) {
    return switch (eventType) {
      case "BOOKING_CREATED" -> BookingCreatedEvent.class;
      case "BOOKING_CANCELLED" -> BookingCancelledEvent.class;
      case "BOOKING_UPDATED" -> BookingUpdateEvent.class;
      default -> throw new IllegalArgumentException("Unknown event type: " + eventType);
    };
  }
}

package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingConfirmedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Custom serializer and deserializer (Serde) for {@link BookingEvent} domain events.
 *
 * <p>This class uses Jackson to serialize and deserialize booking events based on the {@code
 * eventType} field. It supports all known event subtypes such as: {@code BookingCreatedEvent},
 * {@code BookingCancelledEvent}, etc.
 *
 * <p>This class is annotated with {@code @RequiredArgsConstructor}, meaning the {@link
 * ObjectMapper} is injected via constructor.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-03
 */
@RequiredArgsConstructor
public class BookingEventSerde implements Serde<BookingEvent> {

  private final ObjectMapper mapper;

  private static Class<? extends Record> resolveType(String type) {
    return switch (type) {
      case "BOOKING_CREATED" -> BookingCreatedEvent.class;
      case "BOOKING_CANCELLED" -> BookingCancelledEvent.class;
      case "BOOKING_UPDATED" -> BookingUpdateEvent.class;
      case "BOOKING_CONFIRMED" -> BookingConfirmedEvent.class;
      default -> throw new IllegalArgumentException("Unknown eventType: %s".formatted(type));
    };
  }

  /**
   * Returns a Kafka {@link Serializer} for {@link BookingEvent}.
   *
   * @return A serializer that converts {@code BookingEvent} instances to byte arrays using Jackson.
   * @throws SerializationException if serialization fails.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-03
   */
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

  /**
   * Returns a Kafka {@link Deserializer} for {@link BookingEvent}.
   *
   * <p>The deserializer reads the {@code eventType} field from the JSON and uses it to determine
   * the specific subtype of {@code BookingEvent} to instantiate.
   *
   * @return A deserializer that reads byte arrays and produces {@code BookingEvent} instances.
   * @throws SerializationException if deserialization fails or event type is unknown.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-03
   */
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

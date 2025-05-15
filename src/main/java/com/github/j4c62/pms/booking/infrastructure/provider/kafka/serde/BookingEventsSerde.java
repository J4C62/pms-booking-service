package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import java.util.ArrayList;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Custom {@link Serde} implementation for serializing and deserializing {@link BookingEvents}.
 *
 * <p>This serde uses a Jackson {@link ObjectMapper} configured with the Java Time module to handle
 * JSON serialization of the list of {@link BookingEvent} instances contained within a {@link
 * BookingEvents} object. It delegates the serialization and deserialization of individual {@link
 * BookingEvent} instances to {@link BookingEventSerde}.
 *
 * <p>Serialization converts the {@code BookingEvents} into a JSON array of events, while
 * deserialization reconstructs a {@code BookingEvents} instance from a JSON array.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-02
 */
public class BookingEventsSerde implements Serde<BookingEvents> {

  private final BookingEventSerde bookingEventSerde;
  private final ObjectMapper objectMapper;

  /**
   * Constructs a new {@code BookingEventsSerde} with default Jackson ObjectMapper configuration.
   */
  public BookingEventsSerde() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
    this.bookingEventSerde = new BookingEventSerde(objectMapper);
  }

  /**
   * Provides a serializer for {@link BookingEvents} which serializes the contained list of booking
   * events to JSON bytes.
   *
   * @return a {@link Serializer} for BookingEvents
   * @author Jose Antonio (J4c62)
   * @since 2025-05-02
   */
  @Override
  public Serializer<BookingEvents> serializer() {
    return (topic, data) -> {
      try {
        return objectMapper.writeValueAsBytes(data.events());
      } catch (Exception e) {
        throw new SerializationException("Error serializing BookingEvents", e);
      }
    };
  }

  /**
   * Provides a deserializer for {@link BookingEvents} which reads a JSON array of booking events
   * and reconstructs the {@code BookingEvents} instance.
   *
   * @return a {@link Deserializer} for BookingEvents
   * @author Jose Antonio (J4c62)
   * @since 2025-05-02
   */
  @Override
  public Deserializer<BookingEvents> deserializer() {
    return (topic, bytes) -> {
      try {
        var events = new ArrayList<BookingEvent>();
        var root = objectMapper.readTree(bytes);
        for (var node : root) {
          var event =
              bookingEventSerde.deserializer().deserialize(topic, node.toString().getBytes());
          events.add(event);
        }
        return new BookingEvents(events);
      } catch (Exception e) {
        throw new SerializationException("Error deserializing BookingEvents", e);
      }
    };
  }
}

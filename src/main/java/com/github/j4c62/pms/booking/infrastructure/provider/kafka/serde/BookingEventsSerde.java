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

public class BookingEventsSerde implements Serde<BookingEvents> {

  private final BookingEventSerde bookingEventSerde;
  private final ObjectMapper objectMapper;

  public BookingEventsSerde() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
    this.bookingEventSerde = new BookingEventSerde(objectMapper);
  }

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

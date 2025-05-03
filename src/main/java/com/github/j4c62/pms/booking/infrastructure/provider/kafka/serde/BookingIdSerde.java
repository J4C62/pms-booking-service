package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class BookingIdSerde implements Serde<BookingId> {
  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public Serializer<BookingId> serializer() {
    return (topic, data) -> {
      try {
        return mapper.writeValueAsBytes(data);
      } catch (Exception e) {
        throw new RuntimeException("Serialization error", e);
      }
    };
  }

  @Override
  public Deserializer<BookingId> deserializer() {
    return (topic, bytes) -> {
      try {
        return mapper.readValue(bytes, BookingId.class);
      } catch (Exception e) {
        throw new RuntimeException("Deserialization error", e);
      }
    };
  }
}

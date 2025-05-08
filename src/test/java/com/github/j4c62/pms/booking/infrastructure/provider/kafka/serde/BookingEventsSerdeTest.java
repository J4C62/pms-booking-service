package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.nio.charset.StandardCharsets;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({BookingEventsSerde.class, BookingEventSerde.class, JacksonAutoConfiguration.class})
class BookingEventsSerdeTest {

  @Autowired private BookingEventsSerde bookingEventsSerde;

  @Test
  void givenInvalidDataWhenSerializerThenThrowsSerializationException() {
    var serializer = bookingEventsSerde.serializer();

    assertThatThrownBy(() -> serializer.serialize("booking-topic", null))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Error serializing BookingEvents");
  }

  @Test
  void givenInvalidDataWhenDeserializerThenThrowsSerializationException() {
    byte[] invalidData = "invalid json".getBytes(StandardCharsets.UTF_8);

    var deserializer = bookingEventsSerde.deserializer();

    assertThatThrownBy(() -> deserializer.deserialize("booking-topic", invalidData))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Error deserializing BookingEvents");
  }
}

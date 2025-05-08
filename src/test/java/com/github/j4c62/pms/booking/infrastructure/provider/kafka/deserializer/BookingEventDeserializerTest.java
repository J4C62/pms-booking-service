package com.github.j4c62.pms.booking.infrastructure.provider.kafka.deserializer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.j4c62.pms.booking.infrastructure.provider.kafka.resolver.BookingEventTypeResolver;
import io.cloudevents.core.builder.CloudEventBuilder;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({
  BookingEventDeserializer.class,
  BookingEventTypeResolver.class,
  JacksonAutoConfiguration.class
})
class BookingEventDeserializerTest {

  @Autowired private BookingEventDeserializer bookingEventDeserializer;

  @Test
  void givenInvalidCloudEvent_whenDeserialized_thenThrowSerializationException() {
    var invalidEvent =
        CloudEventBuilder.v1()
            .withId("1")
            .withSource(URI.create("test"))
            .withType("unknown.type")
            .withData("{}".getBytes(StandardCharsets.UTF_8))
            .withDataContentType("application/json")
            .build();

    assertThatThrownBy(() -> bookingEventDeserializer.deserialize(invalidEvent))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to deserialize BookingEvent");
  }
}

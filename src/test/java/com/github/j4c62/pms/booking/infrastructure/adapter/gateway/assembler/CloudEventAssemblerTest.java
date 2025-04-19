package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import io.cloudevents.CloudEvent;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName(
    "Unit tests for CloudEventAssembler - Verifying CloudEvent conversion and exception handling")
class CloudEventAssemblerTest {
  @Mock private ObjectMapper objectMapper;

  @InjectMocks private CloudEventAssembler cloudEventAssembler;

  @Test
  @DisplayName(
      "Given BookingCreatedEvent when converted to CloudEvent then should be a valid CloudEvent")
  void givenBookingCreatedEventWhenConvertedToCloudEventThenShouldBeValidCloudEvent()
      throws JsonProcessingException {
    UUID bookingId = UUID.randomUUID();
    BookingCreatedEvent bookingCreatedEvent =
        new BookingCreatedEvent(bookingId, "property1", "guest1", "2025-04-20", "2025-04-21");

    String expectedJson = "{\"bookingId\":\"" + bookingId + "\"}";
    when(objectMapper.writeValueAsString(bookingCreatedEvent)).thenReturn(expectedJson);

    CloudEvent cloudEvent =
        cloudEventAssembler.toCloudEvent(bookingCreatedEvent, BookingEventType.BOOKING_CREATED);

    assertThat(cloudEvent).isNotNull();
    assertThat(cloudEvent.getSource()).isEqualTo(URI.create("service://booking-service"));
    assertThat(cloudEvent.getType()).isEqualTo(BookingEventType.BOOKING_CREATED.getEventType());
    assertThat(cloudEvent.getDataContentType()).isEqualTo("application/json");
    assertThat(cloudEvent.getData()).isNotNull();
  }

  @Test
  @DisplayName(
      "Given ObjectMapper throws an exception when serializing BookingCreatedEvent when converted to CloudEvent then should throw RuntimeException")
  void
      givenObjectMapperThrowsExceptionWhenSerializingBookingCreatedEventThenShouldThrowRuntimeException()
          throws JsonProcessingException {
    when(objectMapper.writeValueAsString(any())).thenThrow(new JsonProcessingException("Boom!") {});

    assertThatThrownBy(
            () -> cloudEventAssembler.toCloudEvent("booking", BookingEventType.BOOKING_CREATED))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("Boom!");
  }
}

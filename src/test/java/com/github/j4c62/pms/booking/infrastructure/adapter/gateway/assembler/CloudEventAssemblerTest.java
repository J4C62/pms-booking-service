package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({CloudEventAssembler.class, JacksonAutoConfiguration.class})
class CloudEventAssemblerTest {
  @MockitoBean private ObjectMapper objectMapper;

  @Autowired private CloudEventAssembler cloudEventAssembler;

  @Test
  void givenABookingEventThatCannotSerializedWhenToCloudEventThenThrowIllegalStateException(
      @Autowired CloudEventAssembler cloudEventAssembler) throws JsonProcessingException {

    BookingEvent mockEvent = mock(BookingCreatedEvent.class);
    when(mockEvent.eventType()).thenReturn(BookingEventType.BOOKING_CREATED);

    when(objectMapper.writeValueAsString(mockEvent))
        .thenThrow(new JsonProcessingException("boom") {});

    assertThatThrownBy(() -> cloudEventAssembler.toCloudEvent(mockEvent))
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("Failed to serialize");
  }
}

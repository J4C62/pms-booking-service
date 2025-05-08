package com.github.j4c62.pms.booking.infrastructure.adapter.driven.assembler;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import java.util.UUID;
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

  @Test
  void givenABookingEventThatCannotSerializedWhenToCloudEventThenThrowIllegalStateException(
      @Autowired CloudEventAssembler cloudEventAssembler) throws JsonProcessingException {
    var bookingEvent = createBookingEvent(new BookingId(UUID.randomUUID()));

    when(objectMapper.writeValueAsString(bookingEvent))
        .thenThrow(new JsonProcessingException("boom") {});

    assertThatThrownBy(() -> cloudEventAssembler.toCloudEvent(bookingEvent))
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("Failed to serialize");
  }
}

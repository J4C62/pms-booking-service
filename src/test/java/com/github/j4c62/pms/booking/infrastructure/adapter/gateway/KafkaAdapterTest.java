package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdatedEvent;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.CloudEventAssembler;
import java.util.UUID;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for KafkaAdapter - Verifying the publishing of booking events")
class KafkaAdapterTest {
  @Mock private CloudEventAssembler cloudEventAssembler;
  @Mock private KafkaTemplate<String, Object> kafkaTemplate;
  @InjectMocks private KafkaAdapter kafkaAdapter;
  @Captor private ArgumentCaptor<ProducerRecord<String, Object>> producerRecordCaptor;

  @Test
  @DisplayName("Should publish BookingCreated event to Kafka")
  void shouldPublishBookingCreatedEvent() {
    UUID bookingId = UUID.randomUUID();
    BookingCreatedEvent bookingCreatedEvent =
        new BookingCreatedEvent(
            bookingId, UUID.randomUUID(), UUID.randomUUID(), "2025-04-20", "2025-04-21");

    kafkaAdapter.publishBookingCreated(bookingCreatedEvent);

    verify(kafkaTemplate).send(producerRecordCaptor.capture());
    var value = producerRecordCaptor.getValue();
    assertThat(value.topic()).isEqualTo(BookingEventType.BOOKING_CREATED.getEventType());
  }

  @Test
  @DisplayName("Should publish BookingUpdated event to Kafka")
  void shouldPublishBookingUpdatedEvent() {
    UUID bookingId = UUID.randomUUID();
    BookingUpdatedEvent bookingUpdatedEvent =
        new BookingUpdatedEvent(bookingId, "2025-03-20", "2025-03-22", "2025-04-20", "2025-04-21");

    kafkaAdapter.publishBookingUpdated(bookingUpdatedEvent);

    verify(kafkaTemplate).send(producerRecordCaptor.capture());
    var value = producerRecordCaptor.getValue();
    assertThat(value.topic()).isEqualTo(BookingEventType.BOOKING_UPDATED.getEventType());
  }

  @Test
  @DisplayName("Should publish BookingCancelled event to Kafka")
  void shouldPublishBookingCancelledEvent() {
    UUID bookingId = UUID.randomUUID();
    BookingCancelledEvent bookingCancelledEvent =
        new BookingCancelledEvent(bookingId, "CancelledBy", "Reason", "2025-05-10");

    kafkaAdapter.publishBookingCancelled(bookingCancelledEvent);
    verify(kafkaTemplate).send(producerRecordCaptor.capture());
    var value = producerRecordCaptor.getValue();
    assertThat(value.topic()).isEqualTo(BookingEventType.BOOKING_CANCELLED.getEventType());
  }
}

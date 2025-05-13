package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import io.cloudevents.CloudEvent;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Objects;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(KafkaFixture.class)
class KafkaProducerAdapterTest {
  @Autowired private ObjectMapper objectMapper;
  @Autowired private KafkaFixture.SetUpFixtureIntegration setUpFixtureIntegration;
  @MockitoBean private KafkaTemplate<String, Object> kafkaTemplate;
  @Captor private ArgumentCaptor<ProducerRecord<String, Object>> recordCaptor;

  @Test
  void givenACreatedEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.createBookingEvent();

    setUpFixtureIntegration.bookingEventPublisher().publish(bookingEvent);

    thenEventIsPublished(bookingEvent, BookingEventType.BOOKING_CREATED, BookingCreatedEvent.class);
  }

  @Test
  void givenAUpdatedEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.updateBookingEvent();

    setUpFixtureIntegration.bookingEventPublisher().publish(bookingEvent);

    thenEventIsPublished(bookingEvent, BookingEventType.BOOKING_UPDATED, BookingUpdateEvent.class);
  }

  @Test
  void givenACancelledEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.cancelBookingEvent();

    setUpFixtureIntegration.bookingEventPublisher().publish(bookingEvent);

    thenEventIsPublished(
        bookingEvent, BookingEventType.BOOKING_CANCELLED, BookingCancelledEvent.class);
  }

  private <T extends BookingEvent> void thenEventIsPublished(
      BookingEvent bookingEvent, BookingEventType bookingEventType, Class<T> eventClass) {

    await()
        .atMost(Duration.ofSeconds(2))
        .untilAsserted(
            () -> {
              verify(kafkaTemplate).send(recordCaptor.capture());
              ProducerRecord<String, Object> value = recordCaptor.getValue();
              assertThat(value.topic()).isEqualTo(bookingEventType.getEventType());

              var cloudEvent = (CloudEvent) value.value();
              var json =
                  new String(
                      Objects.requireNonNull(cloudEvent.getData()).toBytes(),
                      StandardCharsets.UTF_8);
              var event = objectMapper.readValue(json, eventClass);
              assertThat(event).isEqualTo(bookingEvent);
            });
  }
}

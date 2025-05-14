package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({KafkaFixture.class, KafkaProducerAdapter.class})
class KafkaProducerAdapterTest {
  @MockitoBean StreamBridge streamBridge;
  @Autowired BookingEventPublisher bookingEventPublisher;
  @Autowired private KafkaFixture.SetUpFixtureIntegration setUpFixtureIntegration;
  @Captor private ArgumentCaptor<BookingEvent> recordCaptor;

  @Test
  void givenACreatedEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.createBookingEvent();

    bookingEventPublisher.publish(bookingEvent);

    thenEventIsPublished(bookingEvent, BookingCreatedEvent.class);
  }

  @Test
  void givenAUpdatedEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.updateBookingEvent();

    bookingEventPublisher.publish(bookingEvent);
    thenEventIsPublished(bookingEvent, BookingUpdateEvent.class);
  }

  @Test
  void givenACancelledEventWhenPublishThenEventIsPublished() {
    var bookingEvent = setUpFixtureIntegration.cancelBookingEvent();

    bookingEventPublisher.publish(bookingEvent);

    thenEventIsPublished(bookingEvent, BookingCancelledEvent.class);
  }

  private <T extends BookingEvent> void thenEventIsPublished(
      BookingEvent bookingEvent, Class<T> eventClass) {
    verify(streamBridge).send(anyString(), recordCaptor.capture());
    var resultValue = recordCaptor.getValue();
    assertThat(resultValue).isEqualTo(bookingEvent).isExactlyInstanceOf(eventClass);
  }
}

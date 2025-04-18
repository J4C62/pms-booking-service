package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

@ExtendWith(MockitoExtension.class)
class KafkaAdapterTest {

  @Mock private KafkaTemplate<String, Object> kafkaTemplate;

  @InjectMocks private KafkaAdapter kafkaAdapter;

  @Test
  void publishBookingCreated_shouldSendCorrectEvent() {

    BookingCreated bookingCreated =
        new BookingCreated("id123", "property1", "guest1", "2025-04-20", "2025-04-21");
    kafkaAdapter.publishBookingCreated(bookingCreated);

    verify(kafkaTemplate).send(any(ProducerRecord.class));
  }

  @Test
  void publishBookingUpdated_shouldSendCorrectEvent() {

    BookingUpdated bookingUpdated =
        new BookingUpdated("id123", "2025-03-20", "2025-03-22", "2025-04-20", "2025-04-21", "", "");

    kafkaAdapter.publishBookingUpdated(bookingUpdated);

    verify(kafkaTemplate).send(any(ProducerRecord.class));
  }

  @Test
  void publishBookingCancelled_shouldSendCorrectEvent() {

    BookingCancelled bookingCancelled =
        new BookingCancelled("id123", "property1", "2025-04-19", "2025-04-21", "", "", "");

    kafkaAdapter.publishBookingCancelled(bookingCancelled);

    verify(kafkaTemplate).send(any(ProducerRecord.class));
  }
}

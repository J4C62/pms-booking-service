package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType.*;

import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.CloudEventAssembler;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaAdapter implements BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final CloudEventAssembler cloudEventAssembler;

  @Override
  public void publishBookingCreated(BookingCreated bookingCreated) {
    var event = cloudEventAssembler.toCloudEvent(bookingCreated, BOOKING_CREATED);
    kafkaTemplate.send(
        new ProducerRecord<>(BOOKING_CREATED.getEventType(), UUID.randomUUID().toString(), event));
  }

  @Override
  public void publishBookingUpdated(BookingUpdated bookingUpdated) {
    var event = cloudEventAssembler.toCloudEvent(bookingUpdated, BOOKING_UPDATED);
    kafkaTemplate.send(
        new ProducerRecord<>(BOOKING_UPDATED.getEventType(), UUID.randomUUID().toString(), event));
  }

  @Override
  public void publishBookingCancelled(BookingCancelled bookingCancelled) {
    var event = cloudEventAssembler.toCloudEvent(bookingCancelled, BOOKING_CANCELLED);
    kafkaTemplate.send(
        new ProducerRecord<>(
            BOOKING_CANCELLED.getEventType(), UUID.randomUUID().toString(), event));
  }
}

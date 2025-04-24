package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.BookingEventType.*;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdatedEvent;
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
  public void publishBookingCreated(BookingCreatedEvent bookingCreatedEvent) {
    var event = cloudEventAssembler.toCloudEvent(bookingCreatedEvent, BOOKING_CREATED);
    kafkaTemplate.send(
        new ProducerRecord<>(BOOKING_CREATED.getEventType(), UUID.randomUUID().toString(), event));
  }

  @Override
  public void publishBookingUpdated(BookingUpdatedEvent bookingUpdatedEvent) {
    var event = cloudEventAssembler.toCloudEvent(bookingUpdatedEvent, BOOKING_UPDATED);
    kafkaTemplate.send(
        new ProducerRecord<>(BOOKING_UPDATED.getEventType(), UUID.randomUUID().toString(), event));
  }

  @Override
  public void publishBookingCancelled(BookingCancelledEvent bookingCancelledEvent) {
    var event = cloudEventAssembler.toCloudEvent(bookingCancelledEvent, BOOKING_CANCELLED);
    kafkaTemplate.send(
        new ProducerRecord<>(
            BOOKING_CANCELLED.getEventType(), UUID.randomUUID().toString(), event));
  }

  @Override
  public void publish(BookingEvent bookingEvent) {
    //    var event = cloudEventAssembler.toCloudEvent(bookingEvent, BOOKING_CREATED);
    //    kafkaTemplate.send(
    //        new ProducerRecord<>(BOOKING_CREATED.getEventType(), UUID.randomUUID().toString(),
    // event));
  }
}

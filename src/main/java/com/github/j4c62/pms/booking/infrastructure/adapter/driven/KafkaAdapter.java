package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.driven.assembler.CloudEventAssembler;
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
  public void publish(BookingEvent bookingEvent) {
    var cloudEvent = cloudEventAssembler.toCloudEvent(bookingEvent);
    kafkaTemplate.send(
        new ProducerRecord<>(
            bookingEvent.eventType().getEventType(), UUID.randomUUID().toString(), cloudEvent));
  }
}

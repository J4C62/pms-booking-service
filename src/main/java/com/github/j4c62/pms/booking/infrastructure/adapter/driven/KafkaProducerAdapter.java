package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.shared.assembler.CloudEventAssembler;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.Thread.startVirtualThread;

@Service
@RequiredArgsConstructor
public class KafkaProducerAdapter implements BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final CloudEventAssembler cloudEventAssembler;

  @Override
  public void publish(BookingEvent bookingEvent) {
    startVirtualThread(
        () -> {
          var cloudEvent = cloudEventAssembler.toCloudEvent(bookingEvent);
          kafkaTemplate.send(
              new ProducerRecord<>(
                  bookingEvent.eventType().getEventType(),
                  UUID.randomUUID().toString(),
                  cloudEvent));
        });
  }
}

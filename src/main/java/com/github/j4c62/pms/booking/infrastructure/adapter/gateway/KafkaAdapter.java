package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.assembler.CloudEventAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaAdapter implements BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final CloudEventAssembler cloudEventAssembler;

  @Override
  public void publish(BookingEvent bookingEvent) {
    //    var event = cloudEventAssembler.toCloudEvent(bookingEvent, BOOKING_CREATED);
    //    kafkaTemplate.send(
    //        new ProducerRecord<>(BOOKING_CREATED.getEventType(), UUID.randomUUID().toString(),
    // event));
  }
}

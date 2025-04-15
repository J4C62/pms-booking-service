package com.github.j4c62.pms.booking.infrastructure.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;

  public BookingEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void publishBookingCreated(Object event) {}

  public void publishBookingCancelled(Object event) {}
}

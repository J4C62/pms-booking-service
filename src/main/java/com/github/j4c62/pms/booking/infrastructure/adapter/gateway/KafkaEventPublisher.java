package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelled;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreated;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdated;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventPublisher implements BookingEventPublisher {
  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Override
  public void publishBookingCreated(BookingCreated bookingCreated) {}

  @Override
  public void publishBookingUpdated(BookingUpdated bookingUpdated) {}

  @Override
  public void publishBookingCancelled(BookingCancelled bookingCancelled) {}
}

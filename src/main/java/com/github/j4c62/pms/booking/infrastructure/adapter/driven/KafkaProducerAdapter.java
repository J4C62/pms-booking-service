package com.github.j4c62.pms.booking.infrastructure.adapter.driven;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerAdapter implements BookingEventPublisher {
  private final StreamBridge streamBridge;

  @Override
  public void publish(BookingEvent bookingEvent) {
    streamBridge.send("bookingEventSupplier-out-0", bookingEvent);
  }
}

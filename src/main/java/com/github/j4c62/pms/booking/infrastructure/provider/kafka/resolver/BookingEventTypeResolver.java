package com.github.j4c62.pms.booking.infrastructure.provider.kafka.resolver;

import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class BookingEventTypeResolver {

  private static final Map<String, Class<? extends BookingEvent>> EVENT_TYPE =
      Map.of(
          BookingEventType.BOOKING_CREATED.getEventType(), BookingCreatedEvent.class,
          BookingEventType.BOOKING_CANCELLED.getEventType(), BookingCancelledEvent.class,
          BookingEventType.BOOKING_UPDATED.getEventType(), BookingUpdateEvent.class,
          BookingEventType.BOOKING_CONFIRMED.getEventType(), BookingConfirmedEvent.class);

  public Class<? extends BookingEvent> resolve(String rawType) {
    try {
      return Optional.ofNullable(EVENT_TYPE.get(rawType))
          .orElseThrow(() -> new IllegalArgumentException("Unknown event type: " + rawType));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid or unknown event type: " + rawType, e);
    }
  }
}

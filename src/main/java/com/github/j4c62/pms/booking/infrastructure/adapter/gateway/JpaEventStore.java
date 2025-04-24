package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.aggregate.EventStore;
import com.github.j4c62.pms.booking.domain.aggregate.event.*;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.converter.JsonConverter;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingEventJpaRepository;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEventEntity;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaEventStore implements EventStore {

  private final BookingEventJpaRepository eventRepository;
  private final JsonConverter jsonConverter;

  @Override
  public void appendEvents(BookingId bookingId, List<BookingEvent> events) {
    List<BookingEventEntity> entities =
        events.stream()
            .map(
                event ->
                    new BookingEventEntity(
                        null,
                        bookingId.value(),
                        event.getClass().getSimpleName(),
                        jsonConverter.toJson(event),
                        Instant.now()))
            .toList();
    eventRepository.saveAll(entities);
  }

  @Override
  public List<BookingEvent> getEventsForBooking(BookingId bookingId) {
    //    return eventRepository.findByBookingIdOrderByOccurredAtAsc(bookingId.value()).stream()
    //        .map(
    //            entity ->
    //                (BookingEvent)
    //                    jsonConverter.fromJson(entity.getPayload(),
    // resolveType(entity.getEventType())))
    //        .toList();
    return null;
  }

  private Class<? extends BookingEvent> resolveType(String eventType) {
    return switch (eventType) {
      case "BookingCreatedEvent" -> BookingCreatedEvent.class;
      case "BookingCancelledEvent" -> BookingCancelledEvent.class;
      case "BookingUpdateEvent" -> BookingUpdateEvent.class;
      default -> throw new IllegalArgumentException("Unknown event type: " + eventType);
    };
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.decorator;

import com.github.j4c62.pms.booking.domain.aggregate.EventStore;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@RequiredArgsConstructor
public class EventStoreDecorator implements EventStore {
  private final EventStore delegate;
  private final BookingEventPublisher bookingEventPublisher;

  @Override
  public void appendEvents(BookingId bookingId, List<BookingEvent> events) {
    delegate.appendEvents(bookingId, events);
    events.forEach(bookingEventPublisher::publish);
  }

  @Override
  public List<BookingEvent> getEventsForBooking(BookingId bookingId) {
    return delegate.getEventsForBooking(bookingId);
  }
}

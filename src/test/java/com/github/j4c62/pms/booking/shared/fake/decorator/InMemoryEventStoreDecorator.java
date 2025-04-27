package com.github.j4c62.pms.booking.shared.fake.decorator;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;

@Primary
@RequiredArgsConstructor
public class InMemoryEventStoreDecorator implements EventStore {

  private final EventStore delegate;
  private final BookingEventPublisher bookingEventPublisher;

  @Override
  public void appendEvents(BookingId bookingId, BookingEvents events) {
    delegate.appendEvents(bookingId, events);
    events.events().forEach(bookingEventPublisher::publish);
  }

  @Override
  public BookingEvents getEventsForBooking(BookingId bookingId) {
    return delegate.getEventsForBooking(bookingId);
  }
}

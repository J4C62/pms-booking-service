package com.github.j4c62.pms.booking.shared.fake;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import java.util.ArrayList;
import java.util.List;

public class FakeBookingEventPublisher implements BookingEventPublisher {

  private final List<BookingEvent> publishedEvents = new ArrayList<>();

  @Override
  public void publish(BookingEvent bookingEvent) {
    publishedEvents.add(bookingEvent);
    System.out.println("Published event: " + bookingEvent);
  }

  public List<BookingEvent> getPublishedEvents() {
    return new ArrayList<>(publishedEvents);
  }

  public void clear() {
    publishedEvents.clear();
  }
}

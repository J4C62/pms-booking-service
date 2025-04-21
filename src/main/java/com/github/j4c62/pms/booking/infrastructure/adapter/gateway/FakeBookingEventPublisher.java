package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingUpdatedEvent;

public class FakeBookingEventPublisher implements BookingEventPublisher {
  private boolean wasPublished = false;

  @Override
  public void publishBookingCreated(BookingCreatedEvent event) {
    this.wasPublished = true;
  }

  @Override
  public void publishBookingUpdated(BookingUpdatedEvent bookingUpdatedEvent) {
    this.wasPublished = true;
  }

  @Override
  public void publishBookingCancelled(BookingCancelledEvent bookingCancelledEvent) {
    this.wasPublished = true;
  }

  public boolean wasPublished() {
    return this.wasPublished;
  }
}

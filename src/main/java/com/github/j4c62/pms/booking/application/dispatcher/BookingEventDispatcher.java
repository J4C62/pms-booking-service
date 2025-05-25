package com.github.j4c62.pms.booking.application.dispatcher;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Component responsible for dispatching domain events produced by a {@link BookingAggregate}.
 *
 * <p>This class acts as a coordination point between the domain and infrastructure layers,
 * extracting domain events from the aggregate and forwarding them to the {@link
 * BookingEventPublisher} for asynchronous processing or integration with external systems.
 *
 * <p>Typically invoked after a command has been executed and the aggregate has emitted one or more
 * domain events.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-25
 */
@Component
public record BookingEventDispatcher(BookingEventPublisher bookingEventPublisher) {

  /**
   * Dispatches all domain events emitted by the given {@link BookingAggregate}.
   *
   * <p>This method extracts the events collected by the aggregate during a command execution and
   * publishes each of them via the injected {@link BookingEventPublisher}.
   *
   * @param aggregate The booking aggregate containing domain events to dispatch.
   * @throws NullPointerException if {@code aggregate} or its event list is {@code null}.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-25
   */
  public void dispatch(BookingAggregate aggregate) {
    aggregate.bookingEvents().events().forEach(bookingEventPublisher::publish);
  }
}

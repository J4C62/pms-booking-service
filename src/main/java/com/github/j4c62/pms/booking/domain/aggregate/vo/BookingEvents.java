package com.github.j4c62.pms.booking.domain.aggregate.vo;

import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.util.List;
import java.util.stream.Stream;

/**
 * Value object that encapsulates a sequence of domain events related to a booking.
 *
 * <p>This class provides operations for appending new events, creating empty or immutable event
 * lists, and replaying events on a {@link BookingAggregate} to reconstruct its state.
 *
 * <p>The event list is treated as immutable and is defensively copied on creation to ensure
 * integrity.
 *
 * @param events An immutable list of {@link BookingEvent} instances.
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-23
 */
public record BookingEvents(List<BookingEvent> events) {

  /**
   * Canonical constructor that ensures the events list is never null and always immutable.
   *
   * @param events A list of booking events; can be null.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingEvents {
    events = events == null ? List.of() : List.copyOf(events);
  }

  /**
   * Creates a new {@code BookingEvents} instance from a given list of events.
   *
   * @param events The list of events to include.
   * @return A new {@code BookingEvents} containing the provided events.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-10
   */
  public static BookingEvents of(List<BookingEvent> events) {
    return new BookingEvents(events);
  }

  /**
   * Returns an empty {@code BookingEvents} instance.
   *
   * @return A {@code BookingEvents} with no events.
   * @author Jose Antonio (J4c62)
   * @since 2025-05-08
   */
  public static BookingEvents empty() {
    return new BookingEvents(List.of());
  }

  /**
   * Returns a new {@code BookingEvents} with the given event appended to the current list.
   *
   * @param event The new event to append.
   * @return A new {@code BookingEvents} with the event added.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingEvents append(BookingEvent event) {
    return new BookingEvents(Stream.concat(events.stream(), Stream.of(event)).toList());
  }

  /**
   * Applies each event in the current list to the given {@link BookingAggregate}, replaying them
   * sequentially to produce a new aggregate state.
   *
   * @param base The initial aggregate to which the events will be applied.
   * @return The updated aggregate after all events have been applied.
   * @author Jose Antonio (J4c62)
   * @since 2025-04-23
   */
  public BookingAggregate replayOn(BookingAggregate base) {
    var result = base;
    for (var event : events) {
      result = event.applyTo(result);
    }
    return result;
  }
}

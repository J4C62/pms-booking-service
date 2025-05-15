package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createCancelledBookingEvent;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BookingEventsTest {

  private static BookingEvents createBookingEvents(List<BookingEvent> bookingEvents) {
    return BookingEvents.of(bookingEvents);
  }

  @Test
  void givenEventsNullWhenCreateBookingEventsThenEventsIsEmpty() {
    var events = BookingEvents.of(null);

    assertThat(events.events())
        .as("Expected events to be empty when initialized with null")
        .isEmpty();
  }

  @Test
  void givenEventsNoNullWhenCreateBookingEventsThenEventsIsNoEmpty() {
    var bookingEvent = createCancelledBookingEvent(BookingId.of(UUID.randomUUID()));

    var events = createBookingEvents(List.of(bookingEvent));

    assertThat(events.events())
        .element(0)
        .as("Expected first element to be the same booking event")
        .isEqualTo(bookingEvent);
  }

  @Test
  void givenBookingEventToAppendWhenAppendEventsThenBookingEventsNotNull() {
    var bookingEventBase = createCancelledBookingEvent(BookingId.of(UUID.randomUUID()));
    var bookingEventToAppend = createCancelledBookingEvent(BookingId.of(UUID.randomUUID()));
    var events = createBookingEvents(List.of(bookingEventBase));

    var appendEvents = events.append(bookingEventToAppend);

    assertThat(appendEvents.events())
        .as("Expected events to contain both the base and appended booking events")
        .contains(bookingEventBase, bookingEventToAppend);
  }

  @Test
  void givenBookingAggregateBaseWithEventsWhenReplyOnThenReturnBookingAggregateWithEvents() {

    var bookingEventBase = createCancelledBookingEvent(BookingId.of(UUID.randomUUID()));
    var bookingAggregate =
        createBookingAggregate(
            BookingId.of(UUID.randomUUID()),
            PropertyId.of(UUID.randomUUID()),
            GuestId.of(UUID.randomUUID()),
            BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2)),
            BookingStatus.PENDING,
            BookingEvents.of(List.of(bookingEventBase)));
    var bookingEvents = createBookingEvents(List.of(bookingEventBase));

    var bookingAggregateUpdated = bookingEvents.replayOn(bookingAggregate);

    assertThat(bookingAggregateUpdated.bookingEvents().events())
        .as("Expected the replayed events to include a BookingCancelledEvent as first element")
        .element(0)
        .isExactlyInstanceOf(BookingCancelledEvent.class);
  }
}

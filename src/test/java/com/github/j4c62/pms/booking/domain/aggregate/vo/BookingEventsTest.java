package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(events.events()).isEmpty();
  }

  @Test
  void givenEventsNoNullWhenCreateBookingEventsThenEventsIsNoEmpty() {
    var bookingEvent = createBookingEvent(BookingId.of(UUID.randomUUID()));
    var events = createBookingEvents(List.of(bookingEvent));
    assertThat(events.events()).isNotEmpty().element(0).isEqualTo(bookingEvent);
  }

  @Test
  void givenABookingEventToAppendWhenAppendEventsThenBookingEventsNotNull() {
    var bookingEventBase = createBookingEvent(BookingId.of(UUID.randomUUID()));
    var bookingEventToAppend = createBookingEvent(BookingId.of(UUID.randomUUID()));
    var events = createBookingEvents(List.of(bookingEventBase));

    var appendEvents = events.append(bookingEventToAppend);

    assertThat(appendEvents.events()).isNotEmpty().contains(bookingEventBase, bookingEventToAppend);
  }

  @Test
  void givenABookingAggregateBaseWithEventsWhenReplyOnThenReturnBookingAggregateWithEvents() {
    var bookingEventBase = createBookingEvent(BookingId.of(UUID.randomUUID()));
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
    assertThat(bookingAggregateUpdated).isNotNull();
    assertThat(bookingAggregateUpdated.bookingEvents().events()).contains(bookingEventBase);
  }
}

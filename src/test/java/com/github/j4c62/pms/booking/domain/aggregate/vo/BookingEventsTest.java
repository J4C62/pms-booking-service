package com.github.j4c62.pms.booking.domain.aggregate.vo;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BookingEventsTest {

  private static BookingEvents createBookingEvents(List<BookingEvent> bookingEvents) {
    return new BookingEvents(bookingEvents);
  }

  @Test
  void givenEventsNullWhenCreateBookingEventsThenEventsIsEmpty() {
    var events = new BookingEvents(null);
    assertThat(events.events()).isEmpty();
  }

  @Test
  void givenEventsNoNullWhenCreateBookingEventsThenEventsIsNoEmpty() {
    var bookingEvent = createBookingEvent(new BookingId(UUID.randomUUID()));
    var events = createBookingEvents(List.of(bookingEvent));
    assertThat(events.events()).isNotEmpty().element(0).isEqualTo(bookingEvent);
  }

  @Test
  void givenABookingEventToAppendWhenAppendEventsThenBookingEventsNotNull() {
    var bookingEventBase = createBookingEvent(new BookingId(UUID.randomUUID()));
    var bookingEventToAppend = createBookingEvent(new BookingId(UUID.randomUUID()));
    var events = createBookingEvents(List.of(bookingEventBase));

    var appendEvents = events.append(bookingEventToAppend);

    assertThat(appendEvents.events()).isNotEmpty().contains(bookingEventBase, bookingEventToAppend);
  }

  @Test
  void givenABookingAggregateBaseAndEventsEmptyWhenReplyOnThenReturnIllegalArgumentException() {
    var bookingAggregate =
        createBookingAggregate(
            new BookingId(UUID.randomUUID()),
            new PropertyId(UUID.randomUUID()),
            new GuestId(UUID.randomUUID()),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            BookingStatus.PENDING,
            new BookingEvents(List.of()));
    var bookingEvents = createBookingEvents(List.of());
    assertThatThrownBy(() -> bookingEvents.replayOn(bookingAggregate))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .message()
        .contains("Event stream is empty");
  }

  @Test
  void givenABookingAggregateBaseWithEventsWhenReplyOnThenReturnBookingAggregateWithEvents() {
    var bookingEventBase = createBookingEvent(new BookingId(UUID.randomUUID()));
    var bookingAggregate =
        createBookingAggregate(
            new BookingId(UUID.randomUUID()),
            new PropertyId(UUID.randomUUID()),
            new GuestId(UUID.randomUUID()),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            BookingStatus.PENDING,
            new BookingEvents(List.of(bookingEventBase)));
    var bookingEvents = createBookingEvents(List.of(bookingEventBase));
    var bookingAggregateUpdated = bookingEvents.replayOn(bookingAggregate);
    assertThat(bookingAggregateUpdated).isNotNull();
    assertThat(bookingAggregateUpdated.bookingEvents().events()).contains(bookingEventBase);
  }
}

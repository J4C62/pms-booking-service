package com.github.j4c62.pms.booking.domain.aggregate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class BookingAggregateTest {

  @Test
  void givenACancelledBookingAggregateWhenCancelThenThrowIllegalStateException() {
    var bookingAggregate = getBookingAggregate(BookingStatus.CANCELLED);
    thenMethodThrows(bookingAggregate::cancel, "Booking already cancelled");
  }

  @Test
  void givenAValidBookingAggregateWhenCancelThenStatusChangeToCancelled() {
    var bookingAggregate = getBookingAggregate(BookingStatus.PENDING);
    var cancelledBooking = bookingAggregate.cancel();
    assertThat(cancelledBooking.status()).isEqualTo(BookingStatus.CANCELLED);
  }

  @Test
  void givenACancelledBookingAggregateWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getBookingAggregate(BookingStatus.CANCELLED);
    var newDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(3));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "Cannot update a cancelled booking");
  }

  @Test
  void givenSameBookingDatesWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getBookingAggregate(BookingStatus.PENDING);
    var newDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "No changes detected in booking dates");
  }

  @Test
  void givenAValidBookingDatesWhenUpdateDatesThenBookingDatesUpdated() {
    var bookingAggregate = getBookingAggregate(BookingStatus.PENDING);
    var newDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(7));

    var updatedDates = bookingAggregate.updateDates(newDates);
    assertThat(updatedDates.bookingDates()).isEqualTo(newDates);
  }

  @Test
  void givenANullBookingEventsWhenCreateBookingAggregateThenValueOfBookingEventsIsEmpty() {
    var bookingAggregate = getEventsBookingAggregate(null);
    assertThat(bookingAggregate.bookingEvents().events()).isEmpty();
  }

  @Test
  void givenABookingAggregateWhenToSnapshotThenCreateASnapshot() {
    var bookingSnapshot = getBookingAggregate(BookingStatus.PENDING);
    var snapshot = bookingSnapshot.toSnapshot();

    assertThat(snapshot).isNotNull();
  }

  @Test
  void givenANoNullBookingEventsWhenCreateBookingAggregateThenValueOfBookingEventsIsNotEmpty() {
    var bookingEvent = getBookingEvent();
    var bookingEvents = new BookingEvents(List.of(bookingEvent));

    var bookingAggregate = getEventsBookingAggregate(bookingEvents);

    assertThat(bookingAggregate.bookingEvents().events())
        .isNotEmpty()
        .element(0)
        .isEqualTo(bookingEvent);
  }

  private void thenMethodThrows(ThrowableAssert.ThrowingCallable method, String message) {
    assertThatThrownBy(method)
        .isInstanceOf(IllegalStateException.class)
        .message()
        .contains(message);
  }

  private BookingAggregate getBookingAggregate(BookingStatus status) {
    var bookingId = new BookingId(UUID.randomUUID());
    var propertyId = new PropertyId(UUID.randomUUID());
    var guestId = new GuestId(UUID.randomUUID());
    var bookingDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
    var bookingEvents = new BookingEvents(List.of());
    return new BookingAggregate(
        bookingId, propertyId, guestId, bookingDates, status, bookingEvents);
  }

  private BookingEvent getBookingEvent() {
    var bookingId = new BookingId(UUID.randomUUID());
    var propertyId = new PropertyId(UUID.randomUUID());
    var guestId = new GuestId(UUID.randomUUID());
    var bookingDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
    return new BookingCreatedEvent(bookingId, propertyId, guestId, bookingDates, Instant.now());
  }

  private BookingAggregate getEventsBookingAggregate(BookingEvents bookingEvents) {
    var bookingId = new BookingId(UUID.randomUUID());
    var propertyId = new PropertyId(UUID.randomUUID());
    var guestId = new GuestId(UUID.randomUUID());
    var bookingDates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
    return new BookingAggregate(
        bookingId, propertyId, guestId, bookingDates, BookingStatus.PENDING, bookingEvents);
  }
}

package com.github.j4c62.pms.booking.domain.aggregate;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createCancelledBookingEvent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class BookingAggregateTest {

  private static BookingEvents getBookingEvents(BookingEvent bookingEvent) {
    return BookingEvents.of(List.of(bookingEvent));
  }

  @Test
  void
      givenAEmptyBookingEventsWhenRestoreBookingAggregateFromEventsThenThrowIllegalArgumentException() {
    var bookingEvents = BookingEvents.empty();
    thenMethodThrowsIllegalArgumentException(() -> BookingAggregate.restoreFrom(bookingEvents));
  }

  @Test
  void
      givenABookingEventsAndTheFirstOneIsNotABookingCreatedEventWhenRestoreBookingAggregateThenThrowsIllegalStateException() {
    var bookingId = BookingId.of(UUID.randomUUID());
    var cancelledEvent = BookingEventFactory.createCancelledBookingEvent(bookingId);
    var bookingEvents = getBookingEvents(cancelledEvent);
    thenMethodThrows(
        () -> BookingAggregate.restoreFrom(bookingEvents),
        "First event must be BookingCreatedEvent");
  }

  @Test
  void givenABookingEventValidWhenRestoreBookingAggregateThenReturnBookingAggregate() {
    var bookingEvent = getBookingEvent();
    var bookingEvents = getBookingEvents(bookingEvent);

    var bookingAggregate = BookingAggregate.restoreFrom(bookingEvents);

    assertThat(bookingAggregate.bookingEvents().events())
        .isNotEmpty()
        .element(0)
        .isEqualTo(bookingEvent);
  }

  @Test
  void givenACancelledBookingAggregateWhenCancelThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.CANCELLED);
    thenMethodThrows(bookingAggregate::cancel, "Booking already cancelled");
  }

  @Test
  void givenAValidBookingAggregateWhenCancelThenStatusChangeToCancelled() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.PENDING);
    var cancelledBooking = bookingAggregate.cancel();
    assertThat(cancelledBooking.status()).isEqualTo(BookingStatus.CANCELLED);
  }

  @Test
  void givenAValidBookingAggregateWhenConfirmThenStatusChangeToConfirmed() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.CONFIRMED);
    var cancelledBooking = bookingAggregate.confirm();
    assertThat(cancelledBooking.status()).isEqualTo(BookingStatus.CONFIRMED);
  }

  @Test
  void givenACancelledBookingAggregateWhenConfirmThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.CANCELLED);
    thenMethodThrows(bookingAggregate::confirm, "Cannot confirm a cancelled booking");
  }

  @Test
  void givenACancelledBookingAggregateWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.CANCELLED);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(3));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "Cannot update a cancelled booking");
  }

  @Test
  void givenSameBookingDatesWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.PENDING);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "No changes detected in booking dates");
  }

  @Test
  void givenAValidBookingDatesWhenUpdateDatesThenBookingDatesUpdated() {
    var bookingAggregate = getDefaultBookingAggregate(BookingStatus.PENDING);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(7));

    var updatedDates = bookingAggregate.updateDates(newDates);
    assertThat(updatedDates.bookingDates()).isEqualTo(newDates);
  }

  @Test
  void givenANullBookingEventsWhenCreateBookingAggregateThenValueOfBookingEventsIsEmpty() {
    var bookingAggregate = getBookingAggregate(BookingStatus.PENDING, null);
    assertThat(bookingAggregate.bookingEvents().events()).isEmpty();
  }

  @Test
  void givenANoNullBookingEventsWhenCreateBookingAggregateThenValueOfBookingEventsIsNotEmpty() {
    var bookingEvent = getBookingEvent();
    var bookingEvents = getBookingEvents(bookingEvent);

    var bookingAggregate = getBookingAggregate(BookingStatus.PENDING, bookingEvents);

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

  private void thenMethodThrowsIllegalArgumentException(ThrowableAssert.ThrowingCallable method) {
    assertThatThrownBy(method)
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains("Cannot restore aggregate from empty event list");
  }

  private BookingAggregate getDefaultBookingAggregate(BookingStatus bookingStatus) {
    return getBookingAggregate(bookingStatus, BookingEvents.empty());
  }

  private BookingAggregate getBookingAggregate(BookingStatus status, BookingEvents bookingEvents) {
    var bookingId = BookingId.of(UUID.randomUUID());
    var propertyId = PropertyId.of(UUID.randomUUID());
    var guestId = GuestId.of(UUID.randomUUID());
    var bookingDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
    return createBookingAggregate(
        bookingId, propertyId, guestId, bookingDates, status, bookingEvents);
  }

  private BookingEvent getBookingEvent() {
    return createCancelledBookingEvent(
        getBookingAggregate(BookingStatus.PENDING, BookingEvents.empty()));
  }
}

package com.github.j4c62.pms.booking.domain.aggregate;

import static com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate.restoreFrom;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingAggregateFactory.createBookingAggregate;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createCancelledBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createConfirmedBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createUpdateBookingEvent;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CONFIRMED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class BookingAggregateTest {

  private static BookingEvents getBookingEvents(BookingEvent... bookingEvent) {
    return BookingEvents.of(List.of(bookingEvent));
  }

  @Test
  void givenEmptyBookingEventsWhenRestoreBookingFromEventsThenThrowIllegalArgumentException() {
    var bookingEvents = BookingEvents.empty();
    thenMethodThrowsIllegalArgumentException(() -> restoreFrom(bookingEvents));
  }

  @Test
  void givenTheFirstOneIsNotBookingCreatedEventWhenRestoreBookingThenThrowsIllegalStateException() {
    var bookingId = BookingId.of(UUID.randomUUID());
    var cancelledEvent = createCancelledBookingEvent(bookingId);
    var bookingEvents = getBookingEvents(cancelledEvent);
    thenMethodThrows(() -> restoreFrom(bookingEvents), "First event must be BookingCreatedEvent");
  }

  @Test
  void givenBookingEventValidWhenRestoreBookingThenReturnBookingAggregate() {
    var bookingId = getBookingEvent().bookingId();
    var bookingDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(3));

    var bookingEvents =
        getBookingEvents(
            getBookingEvent(),
            createUpdateBookingEvent(bookingId, bookingDates),
            createConfirmedBookingEvent(bookingId),
            createCancelledBookingEvent(bookingId));

    var bookingAggregate = restoreFrom(bookingEvents);

    assertThat(bookingAggregate.bookingEvents().events())
        .as("Booking events should not be empty after restoring from valid events")
        .isNotEmpty();
  }

  @Test
  void givenCancelledBookingWhenCancelThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(CANCELLED);
    thenMethodThrows(bookingAggregate::cancel, "Booking already cancelled");
  }

  @Test
  void givenValidBookingWhenCancelThenStatusChangeToCancelled() {
    var bookingAggregate = getDefaultBookingAggregate(PENDING);
    var cancelledBooking = bookingAggregate.cancel();
    assertThat(cancelledBooking.status())
        .as("Booking status should be CANCELLED after cancellation")
        .isEqualTo(CANCELLED);
  }

  @Test
  void givenValidBookingWhenConfirmThenStatusChangeToConfirmed() {
    var bookingAggregate = getDefaultBookingAggregate(CONFIRMED);
    var cancelledBooking = bookingAggregate.confirm();
    assertThat(cancelledBooking.status())
        .as("Booking status should be CONFIRMED after confirmation")
        .isEqualTo(CONFIRMED);
  }

  @Test
  void givenCancelledBookingWhenConfirmThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(CANCELLED);
    thenMethodThrows(bookingAggregate::confirm, "Cannot confirm a cancelled booking");
  }

  @Test
  void givenCancelledBookingAggregateWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(CANCELLED);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(3));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "Cannot update a cancelled booking");
  }

  @Test
  void givenSameBookingDatesWhenUpdateDatesThenThrowIllegalStateException() {
    var bookingAggregate = getDefaultBookingAggregate(PENDING);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(2));
    thenMethodThrows(
        () -> bookingAggregate.updateDates(newDates), "No changes detected in booking dates");
  }

  @Test
  void givenValidBookingDatesWhenUpdateDatesThenBookingDatesUpdated() {
    var bookingAggregate = getDefaultBookingAggregate(PENDING);
    var newDates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(7));

    var updatedDates = bookingAggregate.updateDates(newDates);
    assertThat(updatedDates.bookingDates())
        .as("Booking dates should be updated with the new values")
        .isEqualTo(newDates);
  }

  @Test
  void givenNullBookingEventsWhenCreateBookingThenValueOfBookingEventsIsEmpty() {
    var bookingAggregate = getBookingAggregate(PENDING, null);
    assertThat(bookingAggregate.bookingEvents().events())
        .as("Booking events list should be empty when no events are provided")
        .isEmpty();
  }

  @Test
  void givenNoNullBookingEventsWhenCreateBookingThenValueOfBookingEventsIsNotEmpty() {
    var bookingEvent = getBookingEvent();
    var bookingEvents = getBookingEvents(bookingEvent);

    var bookingAggregate = getBookingAggregate(PENDING, bookingEvents);

    assertThat(bookingAggregate.bookingEvents().events())
        .element(0)
        .as("The first event should be the same as the provided booking event")
        .isEqualTo(bookingEvent);
  }

  private void thenMethodThrows(ThrowableAssert.ThrowingCallable method, String message) {
    assertThatThrownBy(method)
        .as("Should throw IllegalStateException with expected message")
        .isInstanceOf(IllegalStateException.class)
        .message()
        .contains(message);
  }

  private void thenMethodThrowsIllegalArgumentException(ThrowableAssert.ThrowingCallable method) {
    assertThatThrownBy(method)
        .as("Should throw IllegalArgumentException when restoring from empty event list")
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
    return createBookingEvent(getBookingAggregate(PENDING, BookingEvents.empty()));
  }
}

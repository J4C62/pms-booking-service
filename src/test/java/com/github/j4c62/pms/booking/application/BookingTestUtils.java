package com.github.j4c62.pms.booking.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import org.mockito.ArgumentCaptor;

public class BookingTestUtils {

  public static BookingOutput when(BookingHandler bookingCommandHandler, Command command) {
    return bookingCommandHandler.handle(command);
  }

  public static void thenTheEventIsPublished(
      BookingEventPublisher bookingEventPublisher,
      int times,
      ArgumentCaptor<BookingEvent> argumentCaptor,
      BookingEventType bookingEventType,
      BookingOutput bookingOutput) {
    verify(bookingEventPublisher, times(times)).publish(argumentCaptor.capture());
    var bookingCreatedEvent = argumentCaptor.getValue();
    assertThat(bookingCreatedEvent.eventType()).isEqualTo(bookingEventType);
    assertThat(bookingCreatedEvent.bookingId()).isEqualTo(bookingOutput.bookingId());
  }

  public static void thenBookingOutputValid(
      BookingOutput output, BookingStatus cancelled, String desc) {
    assertThat(output)
        .isNotNull()
        .matches(bookingOutput -> bookingOutput.bookingId() != null, "bookingId is not null")
        .matches(bookingOutput -> cancelled.equals(bookingOutput.status()), desc);
  }
}

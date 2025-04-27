package com.github.j4c62.pms.booking.application.handler;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import com.github.j4c62.pms.booking.shared.fake.FakeBookingEventPublisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(Fixture.class)
class BookingCommandHandlerTest {
  @Autowired private Fixture.SetUpFixture setUpFixture;

  @AfterEach
  void tearDown() {
    // And: Restore the events states
    setUpFixture.inMemoryEventStore().restoreState();

    // And Finally: The clear events
    ((FakeBookingEventPublisher) setUpFixture.bookingEventPublisher()).clear();
  }

  private BookingOutput when(BookingHandler bookingCommandHandler, Command command) {
    return bookingCommandHandler.handle(command);
  }

  private void thenBookingOutputValid(BookingOutput output, BookingStatus cancelled, String desc) {
    assertThat(output)
        .isNotNull()
        .matches(bookingOutput -> bookingOutput.bookingId() != null, "bookingId is not null")
        .matches(bookingOutput -> cancelled.equals(bookingOutput.status()), desc);
  }

  private void thenEventsPublished(
      int size,
      int element,
      BookingEventPublisher bookingEventPublisher,
      Class<? extends BookingEvent> bookingEventClass) {

    assertThat(((FakeBookingEventPublisher) bookingEventPublisher).getPublishedEvents())
        .hasSize(size)
        .element(element)
        .isInstanceOf(bookingEventClass);
  }

  @Nested
  class CreateBookingTest {

    @Test
    void givenValidCreateBookingCommandShouldReturnValidOutput() {
      // Given: A valid Create Command
      var bookingCommand = setUpFixture.createBookingCommand();
      // And: A valid Command Handler
      var bookingCommandHandler = setUpFixture.bookingCommandHandler();

      // When: The operation is handled
      var output = when(bookingCommandHandler, bookingCommand);

      // Then: Return a booking output with status Pending and correct BookingId
      thenBookingOutputValid(output, PENDING, "status is PENDING");

      // And: The update event is published
      thenEventsPublished(1, 0, setUpFixture.bookingEventPublisher(), BookingCreatedEvent.class);
    }
  }

  @Nested
  class UpdateDatesBookingTest {

    @Test
    void givenValidUpdateBookingCommandShouldReturnValidOutput() {
      // Given: A valid Update Dates Command
      var command = setUpFixture.updateBookingCommand();
      // And: A valid Command Handler
      var bookingCommandHandler = setUpFixture.bookingCommandHandler();

      // When: The operation is handled
      var output = when(bookingCommandHandler, command);

      // Then: Return a booking output with status Pending and correct BookingId
      thenBookingOutputValid(output, PENDING, "status is PENDING");

      // And: The update event is published
      thenEventsPublished(2, 1, setUpFixture.bookingEventPublisher(), BookingUpdateEvent.class);
    }
  }

  @Nested
  class CancelBookingTest {

    @Test
    void givenValidCancelBookingCommandShouldReturnValidOutput() {
      // Given: A valid Cancel Command
      var command = setUpFixture.cancelBookingCommand();
      // And: A valid Command Handler
      var bookingCommandHandler = setUpFixture.bookingCommandHandler();

      // When: The operation is handled
      var output = when(bookingCommandHandler, command);

      // Then: Return a booking output with status CANCELLED and correct BookingId
      thenBookingOutputValid(output, CANCELLED, "status is CANCELLED");

      // And: The cancel event is published
      thenEventsPublished(2, 1, setUpFixture.bookingEventPublisher(), BookingCancelledEvent.class);
    }
  }
}

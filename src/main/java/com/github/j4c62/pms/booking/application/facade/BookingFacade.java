package com.github.j4c62.pms.booking.application.facade;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingFacade {

  private final EventStore eventStore;
  private final SnapshotFacade snapshotFacade;
  private final BookingAggregateMapper bookingAggregateMapper;

  public BookingOutput execute(Command command) {
    if (command instanceof UpdateBookingCommand specificInput) {
      var events = eventStore.getEventsForBooking(specificInput.bookingId());
      var aggregate = snapshotFacade.restoreBookingAggregate(specificInput, events);
      var updatedAggregate = command.applyTo(aggregate);
      saveEvent(updatedAggregate);
      return outputFrom(updatedAggregate);
    }
    if (command instanceof CreateBookingCommand createInput) {
      var aggregate = bookingAggregateMapper.toAggregate(createInput);
      var bookingAggregate = command.applyTo(aggregate);
      saveEvent(bookingAggregate);
      return outputFrom(bookingAggregate);
    }
    throw new IllegalArgumentException("Unsupported input type: " + command.getClass());
  }

  private BookingOutput outputFrom(BookingAggregate aggregate) {
    return new BookingOutput(aggregate.bookingId().value(), aggregate.status());
  }

  private void saveEvent(BookingAggregate aggregate) {
    eventStore.appendEvents(aggregate.bookingId(), aggregate.bookingEvents());
    snapshotFacade.maybeSaveSnapshot(aggregate);
  }
}

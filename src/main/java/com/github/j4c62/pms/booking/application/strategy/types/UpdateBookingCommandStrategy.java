package com.github.j4c62.pms.booking.application.strategy.types;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.application.strategy.BookingCommandStrategy;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.types.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBookingCommandStrategy implements BookingCommandStrategy<UpdateBookingCommand> {
  private final BookingEventStore bookingEventStore;

  private final BookingEventPublisher bookingEventPublisher;
  private final BookingOutputMapper bookingOutputMapper;

  @Override
  public boolean supports(Command command) {
    return command instanceof UpdateBookingCommand;
  }

  @Override
  public BookingOutput execute(UpdateBookingCommand command) {
    var events = bookingEventStore.getEventsForBooking(command.bookingId());
    var aggregate = BookingAggregate.restoreFrom(events);
    var updatedAggregate = command.applyTo(aggregate);
    publishEvent(updatedAggregate);
    return bookingOutputMapper.toBookingOutput(updatedAggregate);
  }

  private void publishEvent(BookingAggregate aggregate) {
    aggregate.bookingEvents().events().forEach(bookingEventPublisher::publish);
  }
}

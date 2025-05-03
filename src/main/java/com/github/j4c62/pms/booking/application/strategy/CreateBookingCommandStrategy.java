package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBookingCommandStrategy implements BookingCommandStrategy<CreateBookingCommand> {
  private final BookingEventPublisher bookingEventPublisher;
  private final BookingAggregateMapper bookingAggregateMapper;
  private final BookingOutputMapper bookingOutputMapper;

  @Override
  public boolean supports(Command command) {
    return command instanceof CreateBookingCommand;
  }

  @Override
  public BookingOutput execute(CreateBookingCommand command) {
    var aggregate = bookingAggregateMapper.toAggregate(command);
    var updated = command.applyTo(aggregate);
    publishEvent(updated);
    return bookingOutputMapper.toBookingOutput(updated);
  }

  private void publishEvent(BookingAggregate aggregate) {
    aggregate.bookingEvents().events().forEach(bookingEventPublisher::publish);
  }
}

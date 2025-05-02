package com.github.j4c62.pms.booking.application.strategy;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapper;
import com.github.j4c62.pms.booking.application.facade.SnapshotFacade;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBookingCommandStrategy implements BookingCommandStrategy<UpdateBookingCommand> {

  private final EventStore eventStore;
  private final SnapshotFacade snapshotFacade;
  private final BookingOutputMapper bookingOutputMapper;

  @Override
  public boolean supports(Command command) {
    return command instanceof UpdateBookingCommand;
  }

  @Override
  public BookingOutput execute(UpdateBookingCommand command) {
    var events = eventStore.getEventsForBooking(command.bookingId());
    var aggregate = snapshotFacade.restoreBookingAggregate(command, events);
    var updatedAggregate = command.applyTo(aggregate);
    saveEvent(updatedAggregate);
    return bookingOutputMapper.toBookingOutput(updatedAggregate);
  }

  private void saveEvent(BookingAggregate aggregate) {
    snapshotFacade.maybeSaveSnapshot(aggregate);
  }
}

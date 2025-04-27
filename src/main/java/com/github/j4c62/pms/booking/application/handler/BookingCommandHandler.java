package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.facade.BookingFacade;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingCommandHandler implements BookingHandler {
  private final BookingFacade bookingFacade;

  @Override
  public BookingOutput handle(Command command) {
    return bookingFacade.execute(command);
  }
}

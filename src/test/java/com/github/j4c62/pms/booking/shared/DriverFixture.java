package com.github.j4c62.pms.booking.shared;

import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.command.types.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.types.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(AggregateFixture.class)
public class DriverFixture {
  @Bean
  @Qualifier("createBookingCommand")
  public Command createBookingCommand(
      PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new CreateBookingCommand(propertyId, guestId, bookingDates);
  }

  @Bean
  @Qualifier("updateBookingDatesCommand")
  public Command updateBookingCommand(BookingId bookingId) {
    var updateReason = "We have to stay seven day more";
    var dates = BookingDates.of(LocalDate.now(), LocalDate.now().plusDays(7));
    return new UpdateBookingDatesCommand(bookingId, dates, updateReason);
  }

  @Bean
  @Qualifier("cancelBookingCommand")
  public Command cancelBookingCommand(BookingId bookingId) {
    var cancelReason = "Emergency";
    var cancelledBy = "guest-1234";
    return new CancelBookingCommand(bookingId, cancelReason, cancelledBy);
  }

  @Bean
  @ConditionalOnMissingBean(BookingHandler.class)
  public BookingHandler bookingCreator() {
    return req ->
        switch (req) {
          case CreateBookingCommand createBookingCommand ->
              new BookingOutput(BookingId.of(UUID.randomUUID()), BookingStatus.PENDING);
          case UpdateBookingDatesCommand updateBookingCommand ->
              new BookingOutput(updateBookingCommand.bookingId(), BookingStatus.PENDING);
          case CancelBookingCommand cancelBookingCommand ->
              new BookingOutput(cancelBookingCommand.bookingId(), BookingStatus.CANCELLED);
          default ->
              throw new IllegalArgumentException(
                  "Unsupported command: %s".formatted(req.getClass()));
        };
  }
}

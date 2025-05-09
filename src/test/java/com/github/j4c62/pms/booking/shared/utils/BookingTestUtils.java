package com.github.j4c62.pms.booking.shared.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.shared.config.Fixture;

public class BookingTestUtils {
  public static void reset(Fixture.SetUpFixture setUpFixture) {
    setUpFixture.inMemoryEventStore().restoreState();
  }

  public static BookingOutput when(BookingHandler bookingCommandHandler, Command command) {
    return bookingCommandHandler.handle(command);
  }

  public static void thenBookingOutputValid(
      BookingOutput output, BookingStatus cancelled, String desc) {
    assertThat(output)
        .isNotNull()
        .matches(bookingOutput -> bookingOutput.bookingId() != null, "bookingId is not null")
        .matches(bookingOutput -> cancelled.equals(bookingOutput.status()), desc);
  }
}

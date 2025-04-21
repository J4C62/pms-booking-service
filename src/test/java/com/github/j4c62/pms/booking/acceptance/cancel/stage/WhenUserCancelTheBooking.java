package com.github.j4c62.pms.booking.acceptance.cancel.stage;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingCreateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingCreateMapperImpl;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapperImpl;
import com.github.j4c62.pms.booking.application.handler.CreateBookingCommandHandler;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.InMemoryBookingAdapter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenUserCancelTheBooking extends Stage<WhenUserCancelTheBooking> {

  @ExpectedScenarioState CreateBookingInput createBookingInput;

  @ProvidedScenarioState BookingOutput bookingOutput;

  @ProvidedScenarioState InMemoryBookingAdapter fakeRepo = new InMemoryBookingAdapter();

  @ProvidedScenarioState
  FakeBookingEventPublisher fakeEventPublisher = new FakeBookingEventPublisher();

  BookingCreateMapper bookingCreateMapper = new BookingCreateMapperImpl();
  BookingEventMapper bookingEventMapper = new BookingEventMapperImpl();

  public WhenUserCancelTheBooking the_booking_is_cancel() {
    var handler =
        new CreateBookingCommandHandler(
            bookingCreateMapper, bookingEventMapper, fakeRepo, fakeEventPublisher);

    bookingOutput = handler.create(createBookingInput);
    return self();
  }
}

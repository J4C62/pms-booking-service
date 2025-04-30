package com.github.j4c62.pms.booking.shared.config;

import com.github.j4c62.pms.booking.application.config.ApplicationConfig;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapperImpl;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingOutputMapperImpl;
import com.github.j4c62.pms.booking.application.creation.restorer.BookingAggregateRestorer;
import com.github.j4c62.pms.booking.application.facade.SnapshotFacade;
import com.github.j4c62.pms.booking.application.handler.BookingCommandHandler;
import com.github.j4c62.pms.booking.application.strategy.BookingCommandExecutor;
import com.github.j4c62.pms.booking.application.strategy.CreateBookingCommandStrategy;
import com.github.j4c62.pms.booking.application.strategy.UpdateBookingCommandStrategy;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.application.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.Command;
import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.command.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import com.github.j4c62.pms.booking.shared.fake.FakeBookingEventPublisher;
import com.github.j4c62.pms.booking.shared.fake.InMemoryEventStore;
import com.github.j4c62.pms.booking.shared.fake.InMemorySnapshotStore;
import com.github.j4c62.pms.booking.shared.fake.decorator.InMemoryEventStoreDecorator;
import com.tngtech.jgiven.integration.spring.EnableJGiven;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@TestConfiguration
@Import({
  BookingCommandHandler.class,
  BookingAggregateRestorer.class,
  InMemoryEventStoreDecorator.class,
  InMemoryEventStore.class,
  InMemorySnapshotStore.class,
  ApplicationConfig.class,
  BookingAggregateMapperImpl.class,
  SnapshotFacade.class,
  FakeBookingEventPublisher.class,
  BookingCommandExecutor.class,
  CreateBookingCommandStrategy.class,
  UpdateBookingCommandStrategy.class,
  BookingOutputMapperImpl.class
})
@EnableJGiven
@ComponentScan(includeFilters = @ComponentScan.Filter(JGivenStage.class))
public class Fixture {

  @Bean
  public BookingId bookingId() {
    return new BookingId(UUID.nameUUIDFromBytes("booking-123".getBytes()));
  }

  @Bean
  public BookingDates bookingDates() {
    return new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2));
  }

  @Bean
  public GuestId guestId() {
    return new GuestId(UUID.randomUUID());
  }

  @Bean
  public PropertyId propertyId() {
    return new PropertyId(UUID.randomUUID());
  }

  @Bean
  @Qualifier("givenValidCreateBookingCommand")
  public Command createBookingCommand(
      PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {
    return new CreateBookingCommand(propertyId, guestId, bookingDates);
  }

  @Bean
  @Qualifier("givenValidUpdateBookingDatesCommand")
  public Command updateBookingCommand(BookingId bookingId) {
    var updateReason = "We have to stay seven day more";
    var dates = new BookingDates(LocalDate.now(), LocalDate.now().plusDays(7));
    return new UpdateBookingDatesCommand(bookingId, dates, updateReason);
  }

  @Bean
  @Qualifier("givenValidCancelBookingCommand")
  public Command cancelBookingCommand(BookingId bookingId) {
    var cancelReason = "Emergency";
    var cancelledBy = "guest-1234";
    return new CancelBookingCommand(bookingId, cancelReason, cancelledBy);
  }

  @Bean
  public SnapshotStore snapshotStore() {
    return new InMemorySnapshotStore();
  }

  @Component
  public record SetUpFixture(
      FakeBookingEventPublisher bookingEventPublisher,
      BookingHandler bookingCommandHandler,
      @Qualifier("givenValidCreateBookingCommand") Command createBookingCommand,
      @Qualifier("givenValidUpdateBookingDatesCommand") Command updateBookingCommand,
      @Qualifier("givenValidCancelBookingCommand") Command cancelBookingCommand,
      InMemoryEventStore inMemoryEventStore) {}
}

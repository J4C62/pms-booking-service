package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingAggregateMapper;
import com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.*;
import com.github.j4c62.pms.booking.domain.driver.input.CreateBookingInput;
import com.github.j4c62.pms.booking.domain.gateway.EventStore;
import com.github.j4c62.pms.booking.domain.gateway.SnapshotStore;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for CreateBookingCommandHandler - Verifying creation and event publishing")
class CreateBookingCommandHandlerTest {

  private static final UUID PROPERTY_ID = UUID.randomUUID();
  private static final UUID GUEST_ID = UUID.randomUUID();
  private static final UUID BOOKING_ID = UUID.randomUUID();
  @Mock private EventStore eventStore;
  @Mock private SnapshotStore snapshotStore;
  @Mock private BookingAggregateMapper bookingAggregateMapper;
  @InjectMocks private CreateBookingCommandHandler handler;

  @Test
  @DisplayName(
      "Given a valid create booking input when handling creation then should store events, save snapshot if needed and return output")
  void
      givenValidCreateBookingInputWhenHandlingCreationThenShouldStoreEventsSaveSnapshotAndReturnOutput() {
    var createBookingInput =
        new CreateBookingInput(
            new PropertyId(PROPERTY_ID),
            new GuestId(GUEST_ID),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)));
    when(bookingAggregateMapper.toAggregate(createBookingInput))
        .thenReturn(
            new BookingAggregate(
                new BookingId(BOOKING_ID),
                new PropertyId(PROPERTY_ID),
                new GuestId(GUEST_ID),
                new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
                BookingStatus.PENDING,
                null));

    var bookingOutput = handler.create(createBookingInput);

    verify(eventStore).appendEvents(any(), any());
    verify(snapshotStore).saveSnapshot(any());

    assertThat(bookingOutput.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(bookingOutput.status()).isEqualTo(BookingStatus.PENDING);
  }

  @Test
  @DisplayName(
      "Given a booking aggregate with few events when creating booking then should not save snapshot")
  void givenBookingAggregateWithFewEventsWhenCreatingBookingThenShouldNotSaveSnapshot() {
    var createBookingInput =
        new CreateBookingInput(
            new PropertyId(PROPERTY_ID),
            new GuestId(GUEST_ID),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)));

    var bookingCreatedEvent =
        new BookingCreatedEvent(
            new BookingId(BOOKING_ID),
            new PropertyId(PROPERTY_ID),
            new GuestId(GUEST_ID),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            Instant.now());

    var bookingAggregate =
        new BookingAggregate(
            new BookingId(BOOKING_ID),
            new PropertyId(PROPERTY_ID),
            new GuestId(GUEST_ID),
            new BookingDates(LocalDate.now(), LocalDate.now().plusDays(2)),
            BookingStatus.PENDING,
            new BookingEvents(List.of(bookingCreatedEvent)));

    when(bookingAggregateMapper.toAggregate(createBookingInput)).thenReturn(bookingAggregate);

    var bookingOutput = handler.create(createBookingInput);

    verify(eventStore).appendEvents(any(), any());
    verify(snapshotStore, never()).saveSnapshot(any());

    assertThat(bookingOutput.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(bookingOutput.status()).isEqualTo(BookingStatus.PENDING);
  }
}

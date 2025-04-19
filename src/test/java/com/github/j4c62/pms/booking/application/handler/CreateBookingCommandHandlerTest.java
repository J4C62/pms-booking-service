package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingCreateMapper;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.gateway.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
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

  private static final String PROPERTY_ID = "property-123";
  private static final String GUEST_ID = "guest-456";
  private static final String START_DATE = "2025-07-01";
  private static final String END_DATE = "2025-07-10";
  private static final UUID BOOKING_ID = UUID.randomUUID();
  @Mock private BookingCreateMapper bookingCreateMapper;
  @Mock private BookingEventMapper bookingEventMapper;
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @InjectMocks private CreateBookingCommandHandler handler;

  @Test
  @DisplayName(
      "Given valid input when creating booking then should persist and publish created event")
  void givenValidInputWhenCreatingBookingThenShouldPersistAndPublishCreatedEvent() {
    var command = new CreateBookingCommand(PROPERTY_ID, GUEST_ID, START_DATE, END_DATE);
    var booking =
        BookingBuilder.builder()
            .bookingId(BOOKING_ID)
            .propertyId(UUID.randomUUID())
            .guestId(GUEST_ID)
            .startDate(START_DATE)
            .endDate(END_DATE)
            .status(BookingStatus.PENDING)
            .build();
    var bookingCreatedEvent =
        new BookingCreatedEvent(BOOKING_ID, PROPERTY_ID, GUEST_ID, START_DATE, END_DATE);

    when(bookingCreateMapper.toBooking(command)).thenReturn(booking);
    when(bookingRepository.save(booking)).thenReturn(booking);
    when(bookingEventMapper.toBookingCreated(booking)).thenReturn(bookingCreatedEvent);

    var result = handler.create(command);

    assertThat(result.bookingId()).isEqualTo(BOOKING_ID);
    assertThat(result.status()).isEqualTo(BookingStatus.PENDING);

    verify(bookingCreateMapper).toBooking(command);
    verify(bookingRepository).save(booking);
    verify(eventPublisher).publishBookingCreated(bookingCreatedEvent);
  }
}

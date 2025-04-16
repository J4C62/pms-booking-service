package com.github.j4c62.pms.booking.application.service;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.dto.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.domain.repository.BookingRepository;
import com.github.j4c62.pms.booking.infrastructure.kafka.BookingEventPublisher;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher bookingEventPublisher;
  @InjectMocks private BookingService bookingService;

  @Test
  @DisplayName("Should return a Booking and Save It in DB given a CreateBookingCommand")
  void shouldCreateBookingAndReturnIt() {
    var command = new CreateBookingCommand("prop-123", "guest-456", "2025-05-01", "2025-05-05");

    when(bookingRepository.save(any(Booking.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));

    var result = bookingService.createBooking(command);

    verify(bookingRepository).save(any(Booking.class));

    verify(bookingEventPublisher).publishBookingCreated(any());

    assertThat(result.bookingId()).isNotBlank().isNotEmpty();
    assertThat(result.propertyId()).isEqualTo("prop-123");
    assertThat(result.guestId()).isEqualTo("guest-456");
    assertThat(result.startDate()).isEqualTo("2025-05-01");
    assertThat(result.endDate()).isEqualTo("2025-05-05");
  }

  @Test
  @DisplayName("Should cancel a booking given a valid bookingId")
  void shouldCancelBooking() {
    var bookingId = "booking-123";

    when(bookingRepository.findById(bookingId))
        .thenReturn(Optional.of(BookingTestFixtures.pendingBooking()));
    when(bookingRepository.save(any(Booking.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));

    Booking result = bookingService.cancelBooking(bookingId);

    verify(bookingRepository).findById(bookingId);
    assertThat(result.status()).isEqualTo(BookingStatus.CANCELLED);
  }

  @Test
  @DisplayName("Should update a Booking's start and end date")
  void shouldUpdateBookingDates() {
    var updatedCommand = new UpdateBookingCommand("2025-05-01", "2025-05-05", "User request");
    var fakeBooking = BookingTestFixtures.pendingBooking();

    when(bookingRepository.findById(fakeBooking.bookingId())).thenReturn(Optional.of(fakeBooking));
    when(bookingRepository.save(any(Booking.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));

    var result = bookingService.updateBooking(fakeBooking.bookingId(), updatedCommand);

    assertThat(result.startDate()).isEqualTo("2025-05-01");
    assertThat(result.endDate()).isEqualTo("2025-05-05");
    assertThat(result.bookingId()).isEqualTo(fakeBooking.bookingId());
    assertThat(result.status()).isEqualTo(PENDING);

    verify(bookingRepository).findById(fakeBooking.bookingId());
    verify(bookingRepository).save(result);
  }
}

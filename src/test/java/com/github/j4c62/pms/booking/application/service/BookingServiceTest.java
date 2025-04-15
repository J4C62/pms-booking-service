package com.github.j4c62.pms.booking.application.service;

import static com.github.j4c62.pms.booking.domain.model.Booking.builder;
import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.dto.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.dto.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.factory.BookingFactory;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.domain.repository.BookingRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
  @Mock private BookingRepository bookingRepository;
  @Mock private BookingFactory bookingFactory;
  @InjectMocks private BookingService bookingService;

  @Test
  @DisplayName("Should return a Booking and Save It in DB given a CreateBookingCommand")
  void shouldCreateBookingAndReturnIt() {
    // Arrange
    var command = new CreateBookingCommand("prop-123", "guest-456", "2025-05-01", "2025-05-05");

    var bookingId = UUID.randomUUID().toString();
    var fakeBooking =
        builder()
            .bookingId(bookingId)
            .propertyId(command.propertyId())
            .guestId(command.guestId())
            .endDate(command.endDate())
            .startDate(command.startDate())
            .build();

    when(bookingFactory.create(
            anyString(), anyString(), anyString(), anyString(), anyString(), any()))
        .thenReturn(fakeBooking);

    when(bookingRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

    // Act
    var result = bookingService.createBooking(command);

    // Assert
    assertThat(result.propertyId()).isEqualTo("prop-123");
    assertThat(result.guestId()).isEqualTo("guest-456");
    assertThat(result.startDate()).isEqualTo("2025-05-01");
    assertThat(result.endDate()).isEqualTo("2025-05-05");
    assertThat(result.bookingId()).isEqualTo(bookingId);

    verify(bookingFactory)
        .create(
            anyString(),
            eq("prop-123"),
            eq("guest-456"),
            eq("2025-05-01"),
            eq("2025-05-05"),
            any());
    verify(bookingRepository).save(result);
  }

  @Test
  @DisplayName("Should cancel a booking given a valid bookingId")
  void shouldCancelBooking() {
    var fakeBooking =
        builder()
            .bookingId("booking-123")
            .propertyId("prop-123")
            .guestId("guest-456")
            .startDate("2025-05-01")
            .endDate("2025-05-05")
            .status(PENDING)
            .build();

    when(bookingRepository.findById(fakeBooking.bookingId())).thenReturn(Optional.of(fakeBooking));
    when(bookingRepository.save(fakeBooking.cancel())).thenReturn(fakeBooking.cancel());
    // Act
    Booking result = bookingService.cancelBooking(fakeBooking.bookingId());

    // Assert
    verify(bookingRepository).findById(fakeBooking.bookingId());
    assertThat(result.status()).isEqualTo(BookingStatus.CANCELLED);
  }

  @Test
  @DisplayName("Should update a Booking's start and end date")
  void shouldUpdateBookingDates() {
    // Arrange
    var bookingId = "booking-123";
    var fakeBooking =
        builder()
            .bookingId(bookingId)
            .propertyId("prop-456")
            .guestId("guest-789")
            .startDate("2025-05-01")
            .endDate("2025-05-05")
            .status(PENDING)
            .build();

    var updatedCommand = new UpdateBookingCommand("2025-05-10", "2025-05-15");

    when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(fakeBooking));
    when(bookingRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

    // Act
    var result = bookingService.updateBooking(bookingId, updatedCommand);

    // Assert
    assertThat(result.startDate()).isEqualTo("2025-05-10");
    assertThat(result.endDate()).isEqualTo("2025-05-15");
    assertThat(result.bookingId()).isEqualTo(bookingId);
    assertThat(result.status()).isEqualTo(PENDING);

    verify(bookingRepository).findById(bookingId);
    verify(bookingRepository).save(result);
  }
}

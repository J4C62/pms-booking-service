package com.github.j4c62.pms.booking.application.handler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.github.j4c62.pms.booking.application.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.application.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.application.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateBookingCommandHandlerTest {

  @Mock private BookingRepository bookingRepository;
  @Mock private BookingEventPublisher eventPublisher;
  @Mock private BookingEventFactory eventFactory;

  @InjectMocks private UpdateBookingCommandHandler handler;

  @Test
  @DisplayName("Should update booking and publish BookingUpdated event")
  void shouldUpdateBookingSuccessfully() {
    var request =
        new UpdateBookingCommand("b123", "2025-08-01", "2025-08-10", "Guest change plans");
    var existing =
        BookingBuilder.builder()
            .bookingId("b123")
            .propertyId("123")
            .guestId("guest11")
            .startDate("2025-05-01")
            .endDate("2025-06-01")
            .build();
    var updated = existing.updateDates("2025-08-01", "2025-08-10");
    var event = BookingEventFactory.createBookingFactory().createBookingUpdated(updated, request);
    var updateOutput = new BookingOutput(updated.bookingId(), updated.status());

    when(bookingRepository.findById("b123")).thenReturn(Optional.of(existing));
    when(bookingRepository.save(updated)).thenReturn(updated);
    when(eventFactory.createBookingUpdated(updated, request)).thenReturn(event);

    var result = handler.update(request);

    verify(bookingRepository).save(updated);
    verify(eventPublisher).publishBookingUpdated(event);
    assertThat(result).isEqualTo(updateOutput);
  }

  @Test
  @DisplayName("Should throw if booking is not found")
  void shouldThrowIfBookingNotFound() {
    var request =
        new UpdateBookingCommand("not_found", "2025-09-01", "2025-09-10", "Guest change plans");
    when(bookingRepository.findById("not_found")).thenReturn(Optional.empty());

    assertThatThrownBy(() -> handler.update(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Booking not found");
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.github.j4c62.pms.booking.application.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.application.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class BookingResponseMapperTest {

  private final BookingEventMapper mapper = Mappers.getMapper(BookingEventMapper.class);

  @Test
  @DisplayName("Should map UpdateBookingInput to BookingUpdatedEvent correctly")
  void shouldMapUpdateBookingInputToBookingUpdatedEvent() {
    var input =
        new UpdateBookingCommand(UUID.randomUUID(), "2025-07-01", "2025-07-10", "Well", "now");

    var event = mapper.toBookingUpdated(input);

    assertThat(event.bookingId()).isEqualTo(input.getBookingId());
    assertThat(event.newEndDate()).isEqualTo(input.getNewEndDate());
    assertThat(event.newStartDate()).isEqualTo(input.getNewStartDate());
  }

  @Test
  @DisplayName("Should map CancelBookingInput to BookingCancelledEvent correctly")
  void shouldMapCancelBookingInputToBookingCancelledEvent() {
    var input =
        new CancelBookingCommand(
            UUID.fromString("123e4567-e89b-12d3-a456-426614174001"), "guest-2", "No longer needed");

    var event = mapper.toBookingCancelledEvent(input);

    assertThat(event.bookingId()).isEqualTo(input.getBookingId());
    assertThat(event.cancelledAt()).isEqualTo(input.getCancelledAt());
    assertThat(event.reason()).isEqualTo(input.getReason());
  }
}

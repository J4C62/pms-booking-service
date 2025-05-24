package com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(BookingRequestMapperImpl.class)
class BookingRequestMapperTest {
  @Autowired private BookingRequestMapper bookingRequestMapper;

  @Test
  void givenEmptyBookingIdWhenMapBookingIdThenThrowIllegalArgumentException() {
    thenThrowIllegalArgumentException(() -> bookingRequestMapper.mapBookingId(""));
  }

  @Test
  void givenEmptyPropertyIdWhenMappingPropertyIdThenThrowIllegalArgumentException() {
    thenThrowIllegalArgumentException(() -> bookingRequestMapper.mapPropertyId(""));
  }

  @Test
  void givenEmptyGuestIdWhenMappingGuestIdThenThrowIllegalArgumentException() {
    thenThrowIllegalArgumentException(() -> bookingRequestMapper.mapGuestId(""));
  }

  @Test
  void givenInvalidDateWhenMappingToLocalDateThenThrowIllegalArgumentException() {
    thenThrowIllegalArgumentException(() -> bookingRequestMapper.toLocalDate(""));
  }

  private void thenThrowIllegalArgumentException(
      ThrowableAssert.ThrowingCallable throwingCallable) {
    assertThatThrownBy(throwingCallable)
        .as("Expected IllegalArgumentException")
        .isExactlyInstanceOf(IllegalArgumentException.class);
  }
}

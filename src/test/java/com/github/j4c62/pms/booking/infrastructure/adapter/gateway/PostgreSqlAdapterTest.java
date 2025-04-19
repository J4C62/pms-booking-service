package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper.BookingMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingJpaProvider;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import com.github.j4c62.pms.booking.shared.BookingTestFactory;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostgreSqlAdapterTest {

  private static final UUID bookingId = UUID.randomUUID();
  @Mock private BookingJpaProvider bookingJpaProvider;
  @Mock private BookingMapper bookingMapper;
  @InjectMocks private PostgreSqlAdapter postgreSqlAdapter;

  @Test
  @DisplayName("Given a booking entity when saved then it should be persisted successfully")
  void givenBookingEntityWhenSavedThenItShouldBePersistedSuccessfully() {
    Booking booking = BookingTestFactory.createDefaultBooking(bookingId);
    BookingEntity entity = BookingTestFactory.createDefaultBookingEntity(bookingId);
    Booking savedBooking = BookingTestFactory.createDefaultBooking(bookingId);

    when(bookingMapper.toEntity(booking)).thenReturn(entity);
    when(bookingJpaProvider.save(entity)).thenReturn(entity);
    when(bookingMapper.toDomain(entity)).thenReturn(savedBooking);

    Booking result = postgreSqlAdapter.save(booking);

    assertEquals(savedBooking, result);
    verify(bookingJpaProvider).save(entity);
  }

  @Test
  @DisplayName("Given a booking ID when deleted then it should be removed from database")
  void givenBookingIdWhenDeletedThenItShouldBeRemovedFromDatabase() {

    postgreSqlAdapter.deleteById(bookingId);

    verify(bookingJpaProvider).deleteById(bookingId);
  }

  @Test
  @DisplayName("Given a booking ID when canceled then it should update the status to canceled")
  void givenBookingIdWhenCanceledThenItShouldUpdateStatusToCanceled() {
    when(bookingJpaProvider.cancelBooking(bookingId)).thenReturn(1);

    Integer affectedRows = postgreSqlAdapter.updateCanceledBooking(bookingId);

    assertEquals(1, affectedRows);
    verify(bookingJpaProvider).cancelBooking(bookingId);
  }

  @Test
  @DisplayName(
      "Given a booking ID and new dates when updated then it should reflect the new dates in the database")
  void givenBookingIdAndNewDatesWhenUpdatedThenItShouldReflectTheNewDatesInTheDatabase() {
    String newStartDate = "2025-05-01";
    String newEndDate = "2025-05-07";
    when(bookingJpaProvider.updateBookingDates(bookingId, newStartDate, newEndDate)).thenReturn(1);

    int affectedRows = postgreSqlAdapter.updateBookingDates(bookingId, newStartDate, newEndDate);

    assertEquals(1, affectedRows);
    verify(bookingJpaProvider).updateBookingDates(bookingId, newStartDate, newEndDate);
  }
}

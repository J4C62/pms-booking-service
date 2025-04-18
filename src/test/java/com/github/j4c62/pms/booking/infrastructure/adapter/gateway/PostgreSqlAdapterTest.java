package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper.BookingMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingJpaProvider;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostgreSqlAdapterTest {

  @Mock private BookingJpaProvider bookingJpaProvider;

  @Mock private BookingMapper bookingMapper;

  @InjectMocks private PostgreSqlAdapter postgreSqlAdapter;

  @Test
  void save() {
    // Arrange
    Booking booking =
        new Booking(
            "id123", "property1", "guest1", "2025-04-20", "2025-04-21", BookingStatus.PENDING);
    BookingEntity entity =
        new BookingEntity(
            "id123", "property1", "guest1", "2025-04-20", "2025-04-21", BookingStatus.PENDING);
    Booking savedBooking =
        new Booking(
            "id123", "property1", "guest1", "2025-04-20", "2025-04-21", BookingStatus.PENDING);

    when(bookingMapper.toEntity(booking)).thenReturn(entity);
    when(bookingJpaProvider.save(entity)).thenReturn(entity);
    when(bookingMapper.toDomain(entity)).thenReturn(savedBooking);

    // Act
    Booking result = postgreSqlAdapter.save(booking);

    // Assert
    assertEquals(savedBooking, result);
    verify(bookingJpaProvider).save(entity);
  }

  @Test
  void findById() {
    // Arrange
    BookingEntity entity =
        new BookingEntity(
            "id123", "property1", "guest1", "2025-04-20", "2025-04-21", BookingStatus.PENDING);
    Booking booking =
        new Booking(
            "id123", "property1", "guest1", "2025-04-20", "2025-04-21", BookingStatus.PENDING);

    when(bookingJpaProvider.findById("id123")).thenReturn(Optional.of(entity));
    when(bookingMapper.toDomain(entity)).thenReturn(booking);

    // Act
    Optional<Booking> result = postgreSqlAdapter.findById("id123");

    // Assert
    assertTrue(result.isPresent());
    assertEquals(booking, result.get());
  }

  @Test
  void deleteById() {
    // Act
    postgreSqlAdapter.deleteById("id123");

    // Assert
    verify(bookingJpaProvider).deleteById("id123");
  }
}

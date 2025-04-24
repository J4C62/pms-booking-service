package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpaProvider extends JpaRepository<BookingEntity, UUID> {
  @Modifying
  @Transactional
  @Query(
      "UPDATE BookingEntity b SET b.status = 'CANCELLED' WHERE b.bookingId = :bookingId AND b.status != 'CANCELLED'")
  Integer cancelBooking(@Param("bookingId") UUID bookingId);

  @Modifying
  @Transactional
  @Query(
"""
    UPDATE BookingEntity b
    SET b.startDate = :newStartDate, b.endDate = :newEndDate
    WHERE b.bookingId = :bookingId
      AND b.status != 'CANCELLED'
      AND (b.startDate != :newStartDate OR b.endDate != :newEndDate)
""")
  int updateBookingDates(
      @Param("bookingId") UUID bookingId,
      @Param("newStartDate") LocalDate newStartDate,
      @Param("newEndDate") LocalDate newEndDate);
}

package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import com.github.j4c62.pms.booking.shared.BookingTestFactory;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
@DisplayName("JPA Integration Tests for Booking Repository")
class JpaIntegrationTest {
  static UUID bookingId;
  @Autowired BookingJpaProvider bookingJpaProvider;

  @BeforeAll
  static void setup() {
    bookingId = UUID.randomUUID();
  }

  @BeforeEach
  void cleanDatabase() {
    bookingJpaProvider.deleteAll();
  }

  @Test
  @DisplayName("Should save a new booking entity successfully")
  void givenBookingEntityWhenSavedThenShouldBePersisted() {
    BookingEntity bookingEntity = BookingTestFactory.createDefaultBookingEntity(bookingId);

    var saved = bookingJpaProvider.save(bookingEntity);

    assertThat(saved).isNotNull();
    assertThat(saved.getBookingId()).isEqualTo(bookingId);
    assertThat(saved.getStatus()).isEqualTo(BookingStatus.PENDING);
  }

  @Test
  @DisplayName("Should delete a booking entity by ID")
  void givenBookingEntityWhenDeletedThenShouldNotExistInDatabase() {
    BookingEntity bookingEntity = BookingTestFactory.createDefaultBookingEntity(bookingId);
    bookingJpaProvider.save(bookingEntity);

    bookingJpaProvider.deleteById(bookingId);

    var afterDelete = bookingJpaProvider.findById(bookingId);
    assertThat(afterDelete).isEmpty();
  }

  @Test
  @DisplayName("Should update the status of a booking entity when canceling")
  void givenBookingIdWhenCancelledThenShouldUpdateStatusToCancelled() {
    BookingEntity bookingEntity = BookingTestFactory.createDefaultBookingEntity(bookingId);
    var bookingSaved = bookingJpaProvider.saveAndFlush(bookingEntity);

    Integer affectedRows = bookingJpaProvider.cancelBooking(bookingSaved.getBookingId());

    assertThat(affectedRows.intValue()).isGreaterThan(0);
  }

  @Test
  @DisplayName("Should update the start and end dates of a booking entity")
  void givenBookingIdAndDatesWhenUpdatedThenShouldReflectInDatabase() {
    BookingEntity bookingEntity = BookingTestFactory.createDefaultBookingEntity(bookingId);
    bookingEntity.setStartDate("2025-05-02");
    bookingEntity.setEndDate("2025-05-06");
    var bookingSaved = bookingJpaProvider.saveAndFlush(bookingEntity);

    String newStartDate = "2025-05-01";
    String newEndDate = "2025-05-07";

    int affectedRows =
        bookingJpaProvider.updateBookingDates(
            bookingSaved.getBookingId(), newStartDate, newEndDate);

    assertThat(affectedRows).isGreaterThan(0);
  }
}

package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEventEntity;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import java.time.Instant;
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
  @Autowired BookingEventJpaRepository bookingJpaProvider;

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
    var bookingEntity =
        BookingEventEntity.builder()
            .bookingId(bookingId)
            .payload("{\"test\": \"test\"}")
            .eventType("BookingCreatedEvent")
            .occurredAt(Instant.now())
            .build();

    var saved = bookingJpaProvider.save(bookingEntity);
    assertThat(saved).isNotNull();
    assertThat(saved.getBookingId()).isEqualTo(bookingEntity.getBookingId());
    assertThat(saved.getPayload()).isEqualTo(bookingEntity.getPayload());
  }

  @Test
  @DisplayName("Should find  booking entities  for id in order by occurred at in asc")
  void givenBookingIdWhenFindBookingThenShouldFoundBookingEntites() {
    var bookingEntity =
        BookingEventEntity.builder()
            .bookingId(bookingId)
            .payload("{\"test\": \"test\"}")
            .eventType("BookingCreatedEvent")
            .occurredAt(Instant.now())
            .build();

    bookingJpaProvider.save(bookingEntity);
    var byBookingIdOrderByOccurredAtAsc =
        bookingJpaProvider.findByBookingIdOrderByOccurredAtAsc(bookingId);

    assertThat(byBookingIdOrderByOccurredAtAsc).isNotNull();
    assertThat(byBookingIdOrderByOccurredAtAsc.getFirst()).isEqualTo(bookingEntity);
  }
}

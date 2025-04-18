package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
class JpaIntegrationTest {
  static String bookingId;
  @Autowired BookingJpaProvider bookingJpaProvider;

  @BeforeAll
  static void setup() {
    bookingId = UUID.randomUUID().toString();
  }

  @BeforeEach
  void cleanDatabase() {
    bookingJpaProvider.deleteAll();
  }

  @Test
  void save() {
    var saved =
        bookingJpaProvider.save(
            BookingEntity.builder().bookingId(bookingId).status(BookingStatus.PENDING).build());

    assertThat(saved).isNotNull();
    assertThat(saved.getBookingId()).isEqualTo(bookingId);
    assertThat(saved.getStatus()).isEqualTo(BookingStatus.PENDING);
  }

  @Test
  void findById() {
    bookingJpaProvider.save(
        BookingEntity.builder().bookingId(bookingId).status(BookingStatus.PENDING).build());

    var found = bookingJpaProvider.findById(bookingId);

    assertThat(found).isPresent();
    assertThat(found).isNotEmpty();
    found.ifPresent(booking -> assertThat(booking.getStatus()).isEqualTo(BookingStatus.PENDING));
  }

  @Test
  void deleteById() {
    bookingJpaProvider.save(BookingEntity.builder().bookingId(bookingId).build());

    bookingJpaProvider.deleteById(bookingId);

    var afterDelete = bookingJpaProvider.findById(bookingId);
    assertThat(afterDelete).isEmpty();
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.domain.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.UUID;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.BookingJpaProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(
    properties = {
      "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres",
      "spring.datasource.username=postgres",
      "spring.datasource.password=postgres",
      "spring.jpa.hibernate.ddl-auto=update"
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class BookingDatabaseIntegrationTest {
  @Container @ServiceConnection
  public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres");
  static String bookingId;
  @Autowired BookingDatabase bookingDatabase;

  @BeforeAll
  static void setup() {
    bookingId = UUID.randomUUID().toString();
  }

  @BeforeEach
  void cleanDatabase(@Autowired BookingJpaProvider bookingJpaProvider) {
    bookingJpaProvider.deleteAll();
  }

  @Test
  void save() {
    var saved =
        bookingDatabase.save(
            BookingBuilder.builder().bookingId(bookingId).status(BookingStatus.PENDING).build());

    assertThat(saved).isNotNull();
    assertThat(saved.bookingId()).isEqualTo(bookingId);
    assertThat(saved.status()).isEqualTo(BookingStatus.PENDING);
  }

  @Test
  void findById() {
    bookingDatabase.save(
        BookingBuilder.builder().bookingId(bookingId).status(BookingStatus.PENDING).build());

    var found = bookingDatabase.findById(bookingId);

    assertThat(found).isPresent();
    assertThat(found).isNotEmpty();
    found.ifPresent(booking -> assertThat(booking.status()).isEqualTo(BookingStatus.PENDING));
  }

  @Test
  void deleteById() {
    bookingDatabase.save(
        BookingBuilder.builder().bookingId(bookingId).status(BookingStatus.PENDING).build());

    bookingDatabase.deleteById(bookingId);

    var afterDelete = bookingDatabase.findById(bookingId);
    assertThat(afterDelete).isEmpty();
  }
}

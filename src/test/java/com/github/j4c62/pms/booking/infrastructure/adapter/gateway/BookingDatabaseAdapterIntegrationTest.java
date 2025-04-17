package com.github.j4c62.pms.booking.infrastructure.adapter.gateway;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.github.j4c62.pms.booking.domain.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.UUID;
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
class BookingDatabaseAdapterIntegrationTest {
  @Container @ServiceConnection
  public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres");
  @Autowired BookingDatabaseAdapter bookingDatabaseAdapter;

  @Test
  void save() {
    Booking save =
        bookingDatabaseAdapter.save(
            BookingBuilder.builder()
                .bookingId(UUID.randomUUID().toString())
                .status(BookingStatus.PENDING)
                .build());

    assertThat(save).isNotNull();
    assertThat(save.bookingId()).isNotEmpty().isNotNull();
    assertThat(save.status()).isEqualTo(BookingStatus.PENDING);
  }
}

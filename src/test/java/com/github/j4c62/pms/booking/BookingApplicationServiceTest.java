package com.github.j4c62.pms.booking;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BookingApplicationServiceTest {
  @Autowired BookingFactory bookingFactory;
  @Autowired BookingEventFactory bookingEventFactory;

  @Test
  void contextLoads() {
    assertThat(bookingFactory).isNotNull();
    assertThat(bookingEventFactory).isNotNull();
  }
}

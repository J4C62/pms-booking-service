package com.github.j4c62.pms.booking.application.config;

import com.github.j4c62.pms.booking.application.creation.factory.BookingEventFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public BookingEventFactory bookingEventFactory() {
    return BookingEventFactory.createBookingFactory();
  }
}

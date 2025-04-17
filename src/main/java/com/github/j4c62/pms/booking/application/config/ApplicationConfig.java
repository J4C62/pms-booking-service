package com.github.j4c62.pms.booking.application.config;

import com.github.j4c62.pms.booking.domain.creation.factory.BookingEventFactory;
import com.github.j4c62.pms.booking.domain.creation.factory.BookingFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public BookingFactory bookingFactoryFactory() {
    return BookingFactory.createBookingFactory();
  }

  @Bean
  public BookingEventFactory bookingEventFactory() {
    return BookingEventFactory.createBookingFactory();
  }
}

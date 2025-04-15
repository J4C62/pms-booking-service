package com.github.j4c62.pms.booking.config;

import com.github.j4c62.pms.booking.domain.factory.BookingFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public BookingFactory bookingFactory() {
    return BookingFactory.createBookingFactory();
  }
}

package com.github.j4c62.pms.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Booking microservice application.
 *
 * <p>This class bootstraps the Spring Boot context and initializes all components necessary to
 * handle booking commands and events.
 *
 * <p>It acts as the root of the service's configuration and component scan.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-15
 */
@SpringBootApplication
public class BookingApplicationService {
  /**
   * Starts the Booking application.
   *
   * @param args Command-line arguments passed to the application (if any).
   * @author Jose Antonio (J4c62)
   * @since 2025-04-15
   */
  public static void main(String[] args) {
    SpringApplication.run(BookingApplicationService.class, args);
  }
}

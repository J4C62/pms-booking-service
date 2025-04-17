package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.domain.creation.builder.BookingBuilder;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import java.util.UUID;
import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ImportAutoConfiguration({
  GrpcServerAutoConfiguration.class,
  GrpcServerFactoryAutoConfiguration.class,
  GrpcClientAutoConfiguration.class
})
@ActiveProfiles("test")
public class GrpcIntegrationTestConfig {

  @Bean
  public BookingCreator bookingCreator() {
    return createBookingRequest ->
        BookingBuilder.builder().bookingId(UUID.randomUUID().toString()).build();
  }

  @Bean
  public BookingCanceller bookingCanceller() {
    return cancelBookingRequest ->
        BookingBuilder.builder().bookingId(cancelBookingRequest.bookingId()).build();
  }

  @Bean
  public BookingUpdater bookingUpdater() {
    return updateBookingRequest ->
        BookingBuilder.builder().bookingId(updateBookingRequest.bookingId()).build();
  }
}

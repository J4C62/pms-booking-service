package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
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
        new BookingOutput(UUID.randomUUID().toString(), BookingStatus.PENDING);
  }

  @Bean
  public BookingCanceller bookingCanceller() {
    return cancelBookingRequest ->
        new BookingOutput(UUID.randomUUID().toString(), BookingStatus.CANCELLED);
  }

  @Bean
  public BookingUpdater bookingUpdater() {
    return updateBookingRequest ->
        new BookingOutput(UUID.randomUUID().toString(), BookingStatus.PENDING);
  }
}

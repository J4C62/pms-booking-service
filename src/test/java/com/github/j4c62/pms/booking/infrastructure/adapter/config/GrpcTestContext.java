package com.github.j4c62.pms.booking.infrastructure.adapter.config;

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
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@ImportAutoConfiguration({
  GrpcServerAutoConfiguration.class,
  GrpcServerFactoryAutoConfiguration.class,
  GrpcClientAutoConfiguration.class
})
@TestConfiguration
public class GrpcTestContext {
  @Bean
  public BookingCreator bookingCreator() {
    return req -> new BookingOutput(UUID.randomUUID(), BookingStatus.PENDING);
  }

  @Bean
  public BookingCanceller bookingCanceller() {
    return req -> new BookingOutput(UUID.randomUUID(), BookingStatus.CANCELLED);
  }

  @Bean
  public BookingUpdater bookingUpdater() {
    return req -> new BookingOutput(UUID.randomUUID(), BookingStatus.PENDING);
  }
}

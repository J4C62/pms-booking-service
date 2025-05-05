package com.github.j4c62.pms.booking.infrastructure.config;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.driver.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.command.UpdateBookingDatesCommand;
import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.GrpcControllerAdapter;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception.GrpcExceptionAdvice;
import java.util.UUID;
import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcAdviceAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import({
  GrpcControllerAdapter.class,
  GrpcServerAutoConfiguration.class,
  GrpcServerFactoryAutoConfiguration.class,
  GrpcClientAutoConfiguration.class,
  GrpcAdviceAutoConfiguration.class,
  GrpcExceptionAdvice.class
})
@ComponentScan("com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper")
public class FixtureGrpc {
  @Bean
  public BookingHandler bookingCreator() {
    return req ->
        switch (req) {
          case CreateBookingCommand createBookingCommand ->
              new BookingOutput(new BookingId(UUID.randomUUID()), BookingStatus.PENDING);
          case UpdateBookingDatesCommand updateBookingCommand ->
              new BookingOutput(updateBookingCommand.bookingId(), BookingStatus.PENDING);
          case CancelBookingCommand cancelBookingCommand ->
              new BookingOutput(cancelBookingCommand.bookingId(), BookingStatus.CANCELLED);
          default -> throw new IllegalArgumentException("Unsupported command: %s".formatted(req.getClass()));
        };
  }
}

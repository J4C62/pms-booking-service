package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.infrastructure.adapter.driver.advice.GrpcExceptionAdvice;
import com.github.j4c62.pms.booking.shared.DriverFixture;
import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcAdviceAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Test configuration for gRPC-related components.
 *
 * <p>This fixture sets up the gRPC controller adapter and all required gRPC server/client
 * configurations for integration testing or test context bootstrapping. It also imports driver-side
 * mappers and mock driver beans from {@link DriverFixture}.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-05-01
 */
@TestConfiguration
@Import({
  GrpcControllerAdapter.class,
  GrpcServerAutoConfiguration.class,
  GrpcServerFactoryAutoConfiguration.class,
  GrpcClientAutoConfiguration.class,
  GrpcAdviceAutoConfiguration.class,
  GrpcExceptionAdvice.class,
  DriverFixture.class
})
@ComponentScan("com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper")
public class GrpcFixture {}

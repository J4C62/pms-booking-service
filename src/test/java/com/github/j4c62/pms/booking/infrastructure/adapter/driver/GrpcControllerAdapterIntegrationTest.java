package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.infrastructure.adapter.config.GrpcTestContext;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import java.time.LocalTime;
import java.util.UUID;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({GrpcControllerAdapter.class, GrpcTestContext.class})
@ComponentScan("com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper")
@TestPropertySource(
    properties = {
      "grpc.server.inProcessName=test",
      "grpc.server.port=-1",
      "grpc.client.inProcess.address=in-process:test",
    })
@DisplayName("gRPC Controller Adapter Integration Tests")
class GrpcControllerAdapterIntegrationTest {

  @GrpcClient("inProcess")
  private BookingServiceGrpc.BookingServiceBlockingStub bookingServiceGrpc;

  @Test
  @DisplayName(
      "Given a valid CreateBookingRequest when createBooking is called then booking should be created successfully")
  void
      givenValidCreateBookingRequestWhenCreateBookingIsCalledThenBookingShouldBeCreatedSuccessfully() {
    CreateBookingRequest createBookingRequest =
        CreateBookingRequest.newBuilder()
            .setPropertyId("property-11234")
            .setGuestId("guest-11")
            .setStartDate("2025-05-01")
            .setEndDate("2025-06-01")
            .build();

    var result = bookingServiceGrpc.createBooking(createBookingRequest);

    assertThat(result.getBookingId()).isNotEmpty().isNotNull();
    assertThat(result.getStatus()).isEqualTo(PENDING.name());
  }

  @Test
  @DisplayName(
      "Given a valid CancelBookingRequest when cancelBooking is called then booking should be cancelled successfully")
  void
      givenValidCancelBookingRequestWhenCancelBookingIsCalledThenBookingShouldBeCancelledSuccessfully() {
    CancelBookingRequest cancelBookingRequest =
        CancelBookingRequest.newBuilder()
            .setBookingId(UUID.randomUUID().toString())
            .setReason("Change of plans")
            .setCancelledBy("guest-120")
            .setCancelledAt(LocalTime.now().toString())
            .build();

    var result = bookingServiceGrpc.cancelBooking(cancelBookingRequest);

    assertThat(result.getBookingId()).isNotEmpty().isNotNull();
    assertThat(result.getStatus()).isEqualTo(CANCELLED.name());
  }

  @Test
  @DisplayName(
      "Given a valid UpdateBookingRequest when updateBooking is called then booking should be updated successfully")
  void
      givenValidUpdateBookingRequestWhenUpdateBookingIsCalledThenBookingShouldBeUpdatedSuccessfully() {
    UpdateBookingRequest updateBookingRequest =
        UpdateBookingRequest.newBuilder()
            .setBookingId(UUID.randomUUID().toString())
            .setNewStartDate("2025-05-10")
            .setNewEndDate("2025-06-10")
            .setUpdateReason("Change of plans")
            .build();

    var result = bookingServiceGrpc.updateBooking(updateBookingRequest);

    assertThat(result.getBookingId()).isNotEmpty().isNotNull();
    assertThat(result.getStatus()).isEqualTo(PENDING.name());
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.infrastructure.config.FixtureGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(FixtureGrpc.class)
@TestPropertySource(
    properties = {
      "grpc.server.inProcessName=test",
      "grpc.server.port=-1",
      "grpc.client.inProcess.address=in-process:test",
    })
class GrpcControllerAdapterIntegrationTest {

  @GrpcClient("inProcess")
  private BookingServiceGrpc.BookingServiceBlockingStub bookingServiceGrpc;

  @Test
  void
      givenValidCreateBookingRequestWhenCreateBookingIsCalledThenBookingShouldBeCreatedSuccessfully() {
    var createBookingRequest =
        CreateBookingRequest.newBuilder()
            .setPropertyId(UUID.randomUUID().toString())
            .setGuestId(UUID.randomUUID().toString())
            .setStartDate(LocalDate.now().toString())
            .setEndDate(LocalDate.now().plusDays(2).toString())
            .build();

    var result = bookingServiceGrpc.createBooking(createBookingRequest);

    assertThat(result.getBookingId()).isNotNull();
    assertThat(result.getStatus()).isEqualTo(PENDING.name());
  }

  @Test
  void
      givenValidCancelBookingRequestWhenCancelBookingIsCalledThenBookingShouldBeCancelledSuccessfully() {
    var cancelBookingRequest =
        CancelBookingRequest.newBuilder()
            .setBookingId(UUID.randomUUID().toString())
            .setReason("Change of plans")
            .setCancelledBy("guest-120")
            .setCancelledAt(LocalTime.now().toString())
            .build();

    var result = bookingServiceGrpc.cancelBooking(cancelBookingRequest);

    assertThat(result.getBookingId()).isNotNull();
    assertThat(result.getStatus()).isEqualTo(CANCELLED.name());
  }

  @Test
  void
      givenValidUpdateBookingRequestWhenUpdateBookingIsCalledThenBookingShouldBeUpdatedSuccessfully() {
    var updateBookingRequest =
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

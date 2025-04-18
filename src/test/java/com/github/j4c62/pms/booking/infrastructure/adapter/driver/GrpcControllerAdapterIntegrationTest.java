package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.model.BookingStatus.PENDING;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import java.time.LocalTime;
import java.util.UUID;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    properties = {
      "grpc.server.in-process-name=test",
      "grpc.server.port=-1",
      "grpc.client.inProcess.address=in-process:test",
      "spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false",
      "spring.jpa.hibernate.ddl-auto=none",
    })
class GrpcControllerAdapterIntegrationTest {
  @GrpcClient("inProcess")
  private BookingServiceGrpc.BookingServiceBlockingStub bookingServiceGrpc;

  @Test
  void createBooking() {
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
  void cancelBooking() {
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
  void updateBooking() {
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

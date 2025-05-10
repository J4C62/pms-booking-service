package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.CANCELLED;
import static com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import java.time.Instant;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(GrpcFixture.class)
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
      givenValidCreateBookingRequestWhenCreateBookingIsCalledThenBookingShouldBeCreatedSuccessfully(
          @Autowired PropertyId propertyId,
          @Autowired GuestId guestId,
          @Autowired BookingDates bookingDates) {
    var createBookingRequest =
        CreateBookingRequest.newBuilder()
            .setPropertyId(propertyId.value().toString())
            .setGuestId(guestId.value().toString())
            .setStartDate(bookingDates.startDate().toString())
            .setEndDate(bookingDates.endDate().toString())
            .build();

    var result = bookingServiceGrpc.createBooking(createBookingRequest);

    assertThat(result.getBookingId()).isNotNull();
    assertThat(result.getStatus()).isEqualTo(PENDING.name());
  }

  @Test
  void
      givenValidCancelBookingRequestWhenCancelBookingIsCalledThenBookingShouldBeCancelledSuccessfully(
          @Autowired BookingId bookingId) {
    var cancelBookingRequest =
        CancelBookingRequest.newBuilder()
            .setBookingId(bookingId.value().toString())
            .setReason("Change of plans")
            .setCancelledBy("guest-120")
            .setCancelledAt(Instant.now().toString())
            .build();

    var result = bookingServiceGrpc.cancelBooking(cancelBookingRequest);

    assertThat(result.getBookingId()).isNotNull();
    assertThat(result.getStatus()).isEqualTo(CANCELLED.name());
  }

  @Test
  void
      givenValidUpdateBookingRequestWhenUpdateBookingIsCalledThenBookingShouldBeUpdatedSuccessfully(
          @Autowired BookingId bookingId, @Autowired BookingDates bookingDates) {
    var updateBookingRequest =
        UpdateBookingRequest.newBuilder()
            .setBookingId(bookingId.value().toString())
            .setNewStartDate(bookingDates.startDate().toString())
            .setNewEndDate(bookingDates.startDate().toString())
            .setUpdateReason("Change of plans")
            .build();

    var result = bookingServiceGrpc.updateBooking(updateBookingRequest);

    assertThat(result.getBookingId()).isNotEmpty().isNotNull();
    assertThat(result.getStatus()).isEqualTo(PENDING.name());
  }
}

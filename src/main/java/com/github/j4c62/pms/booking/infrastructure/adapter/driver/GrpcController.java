package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.BookingActions;
import com.github.j4c62.pms.booking.infrastructure.adapter.entrypoint.BookingResponse;
import com.github.j4c62.pms.booking.infrastructure.adapter.entrypoint.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.adapter.entrypoint.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.adapter.entrypoint.CreateBookingRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class GrpcController extends BookingServiceGrpc.BookingServiceImplBase {
  private final BookingActions bookingActions;

  @Override
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var response = BookingResponse.newBuilder().build();
    var createBookingCommand =
        new CreateBookingCommand(
            request.getPropertyId(),
            request.getGuestId(),
            request.getStartDate(),
            request.getEndDate());

    bookingActions.create(createBookingCommand);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void cancelBooking(
      CancelBookingRequest request, StreamObserver<BookingResponse> responseObserver) {}
}

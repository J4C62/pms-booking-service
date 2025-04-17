package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.application.command.CancelBookingCommand;
import com.github.j4c62.pms.booking.application.command.CreateBookingCommand;
import com.github.j4c62.pms.booking.application.command.UpdateBookingCommand;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.infrastructure.adapter.entrypoint.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GrpcController extends BookingServiceGrpc.BookingServiceImplBase {
  private final BookingCreator bookingCreator;
  private final BookingCanceller bookingCanceller;
  private final BookingUpdater bookingUpdater;

  @Override
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var createBookingCommand =
        new CreateBookingCommand(
            request.getPropertyId(),
            request.getGuestId(),
            request.getStartDate(),
            request.getEndDate());

    var booking = bookingCreator.create(createBookingCommand);

    var response =
        BookingResponse.newBuilder()
            .setBookingId(booking.bookingId())
            .setStatus(booking.status().name())
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void cancelBooking(
      CancelBookingRequest request, StreamObserver<BookingResponse> responseObserver) {

    var cancelBookingCommand =
        new CancelBookingCommand(
            request.getBookingId(),
            request.getReason(),
            request.getCancelledBy(),
            request.getCancelledAt());

    var cancel = bookingCanceller.cancel(cancelBookingCommand);
    var response =
        BookingResponse.newBuilder()
            .setBookingId(cancel.bookingId())
            .setStatus(cancel.status().name())
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void updateBooking(
      UpdateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var updateBookingCommand =
        new UpdateBookingCommand(
            request.getBookingId(),
            request.getNewStartDate(),
            request.getNewEndDate(),
            request.getUpdateReason());

    var cancel = bookingUpdater.update(updateBookingCommand);
    var response =
        BookingResponse.newBuilder()
            .setBookingId(cancel.bookingId())
            .setStatus(cancel.status().name())
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}

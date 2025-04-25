package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper.BookingRequestMapper;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper.BookingResponseMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GrpcControllerAdapter extends BookingServiceGrpc.BookingServiceImplBase {
  private final BookingCreator bookingCreator;
  private final BookingCanceller bookingCanceller;
  private final BookingUpdater bookingUpdater;
  private final BookingRequestMapper bookingRequestMapper;
  private final BookingResponseMapper bookingResponseMapper;

  @Override
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var createBookingInput = bookingRequestMapper.toCreateInput(request);
    var createBookingOutput = bookingCreator.create(createBookingInput);

    var response = bookingResponseMapper.toResponse(createBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void cancelBooking(
      CancelBookingRequest request, StreamObserver<BookingResponse> responseObserver) {

    var cancelBookingInput = bookingRequestMapper.toCancelInput(request);
    var cancelBookingOutput = bookingCanceller.cancel(cancelBookingInput);

    var response = bookingResponseMapper.toResponse(cancelBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void updateBooking(
      UpdateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {

    var updateBookingInput = bookingRequestMapper.toUpdateInput(request);
    var updateBookingOutput = bookingUpdater.update(updateBookingInput);

    var response = bookingResponseMapper.toResponse(updateBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}

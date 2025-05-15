package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import com.github.j4c62.pms.booking.domain.driver.handler.BookingHandler;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper.BookingRequestMapper;
import com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper.BookingResponseMapper;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingResponse;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * gRPC controller adapter for the Booking Service.
 *
 * <p>This class acts as the entry point for gRPC requests related to booking operations. It
 * delegates the handling of commands to the {@link BookingHandler} and maps requests and responses
 * via dedicated mappers.
 *
 * <p>Supported operations:
 *
 * <ul>
 *   <li>Create a booking
 *   <li>Cancel an existing booking
 *   <li>Update booking dates
 * </ul>
 *
 * <p>All methods return a {@link BookingResponse} via {@link StreamObserver}. Errors are handled
 * via global gRPC exception handlers.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-17
 */
@GrpcService
@RequiredArgsConstructor
public class GrpcControllerAdapter extends BookingServiceGrpc.BookingServiceImplBase {
  private final BookingHandler bookingHandler;
  private final BookingRequestMapper bookingRequestMapper;
  private final BookingResponseMapper bookingResponseMapper;

  @Override
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var createBookingInput = bookingRequestMapper.toCreateInput(request);
    var createBookingOutput = bookingHandler.handle(createBookingInput);

    var response = bookingResponseMapper.toResponse(createBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void cancelBooking(
      CancelBookingRequest request, StreamObserver<BookingResponse> responseObserver) {

    var cancelBookingInput = bookingRequestMapper.toCancelInput(request);
    var cancelBookingOutput = bookingHandler.handle(cancelBookingInput);

    var response = bookingResponseMapper.toResponse(cancelBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void updateBooking(
      UpdateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {

    var updateBookingInput = bookingRequestMapper.toUpdateInput(request);
    var updateBookingOutput = bookingHandler.handle(updateBookingInput);

    var response = bookingResponseMapper.toResponse(updateBookingOutput);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}

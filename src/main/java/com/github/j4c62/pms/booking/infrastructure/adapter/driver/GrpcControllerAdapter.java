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
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GrpcControllerAdapter extends BookingServiceGrpc.BookingServiceImplBase {
  private final BookingHandler bookingHandler;
  private final BookingRequestMapper bookingRequestMapper;
  private final BookingResponseMapper bookingResponseMapper;

  @Override
  @WithSpan("[controller] Create Booking - GRPC request")
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    var current = Span.current();
    current.setAttribute("booking.guest", request.getGuestId());
    current.setAttribute("booking.property", request.getPropertyId());

    current.setAttribute("booking.source", "web");
    if (log.isInfoEnabled()) {
      log.info(
          "[controller] guest_id:{} request to reserve a property_id:{} ",
          request.getGuestId(),
          request.getPropertyId());
    }

    if (log.isDebugEnabled()) {
      log.debug(
          "[controller] Create booking request -  guest_id:{} | property_id:{}"
              + " | end_date:{} | start_date:{}",
          request.getGuestId(),
          request.getPropertyId(),
          request.getEndDate(),
          request.getStartDate());
    }

    current.addEvent("Starting map");
    var createBookingInput = bookingRequestMapper.toCreateInput(request);
    current.addEvent("Starting handle");
    var createBookingOutput = bookingHandler.handle(createBookingInput);
    current.addEvent("Sending response");
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

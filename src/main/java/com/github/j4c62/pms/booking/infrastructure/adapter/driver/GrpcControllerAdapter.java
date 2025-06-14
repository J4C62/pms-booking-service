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
  private final GrpcCallExecutor grpcCallExecutor;

  @Override
  @WithSpan("[controller] Create Booking - GRPC request")
  public void createBooking(
      CreateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    grpcCallExecutor.execute(
        "createBooking",
        request,
        responseObserver,
        req -> {
          var input = bookingRequestMapper.toCreateInput(req);
          var output = bookingHandler.handle(input);
          return bookingResponseMapper.toResponse(output);
        },
        span -> {
          span.setAttribute("booking.guest", request.getGuestId());
          span.setAttribute("booking.property", request.getPropertyId());
          span.setAttribute("booking.source", "web");
        },
        req -> {
          log.info(
              "[controller] guest_id:{} requested to reserve property_id:{}",
              req.getGuestId(),
              req.getPropertyId());

          log.debug(
              "[controller] Create booking request -  guest_id:{} | property_id:{}"
                  + " | end_date:{} | start_date:{}",
              req.getGuestId(),
              req.getPropertyId(),
              req.getEndDate(),
              req.getStartDate());
        });
  }

  @Override
  @WithSpan("[controller] Cancel Booking - GRPC request")
  public void cancelBooking(
      CancelBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    grpcCallExecutor.execute(
        "cancelBooking",
        request,
        responseObserver,
        req -> {
          var input = bookingRequestMapper.toCancelInput(req);
          var output = bookingHandler.handle(input);
          return bookingResponseMapper.toResponse(output);
        },
        span -> {
          span.setAttribute("booking.guest", request.getGuestId());
          span.setAttribute("booking.id", request.getBookingId());
          span.setAttribute("booking.source", "web");
        },
        req -> {
          log.info(
              "[controller] guest_id:{} cancel booking_id:{}",
              req.getGuestId(),
              req.getBookingId());
          log.debug(
              "[controller] Cancel booking request -  " + "guest_id:{} | booking_id:{} | reason:{}",
              req.getGuestId(),
              req.getBookingId(),
              req.getReason());
        });
  }

  @Override
  @WithSpan("[controller] Update Booking - GRPC request")
  public void updateBooking(
      UpdateBookingRequest request, StreamObserver<BookingResponse> responseObserver) {
    grpcCallExecutor.execute(
        "updateBooking",
        request,
        responseObserver,
        req -> {
          var input = bookingRequestMapper.toUpdateInput(req);
          var output = bookingHandler.handle(input);
          return bookingResponseMapper.toResponse(output);
        },
        span -> {
          span.setAttribute("booking.guest", request.getGuestId());
          span.setAttribute("booking.id", request.getBookingId());
          span.setAttribute("booking.source", "web");
        },
        req -> {
          log.info(
              "[controller] guest_id:{} request to reserve a booking_id:{} ",
              req.getGuestId(),
              req.getBookingId());
          log.debug(
              "[controller] Update booking request -  "
                  + "guest_id:{} | booking_id:{} | new_start_date:{} | new_end_date:{}",
              req.getGuestId(),
              req.getBookingId(),
              req.getNewStartDate(),
              req.getNewEndDate());
        });
  }
}

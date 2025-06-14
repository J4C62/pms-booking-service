package com.github.j4c62.pms.booking.infrastructure.adapter.driver;

import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Component responsible for executing gRPC operations in a standardized and traceable way.
 *
 * <p>This executor handles:
 *
 * <ul>
 *   <li>Tracing of operations using OpenTelemetry {@link Tracer}
 *   <li>Log enrichment with request data
 *   <li>Span decoration with domain-specific metadata
 *   <li>Error handling and span status reporting
 * </ul>
 *
 * <p>It is designed to abstract away common gRPC boilerplate logic such as starting/ending spans,
 * managing {@link io.grpc.stub.StreamObserver} responses, and capturing structured logs.
 *
 * <p>This component is used by the {@link
 * com.github.j4c62.pms.booking.infrastructure.adapter.driver.GrpcControllerAdapter} to encapsulate
 * and unify gRPC execution logic across endpoints.
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-06-14
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class GrpcCallExecutor {

  /**
   * Executes a gRPC call with standardized tracing and logging behavior.
   *
   * <p>This method:
   *
   * <ul>
   *   <li>Creates a {@link Span} with the given operation name
   *   <li>Applies custom span attributes via {@code spanDecorator}
   *   <li>Logs the incoming request using {@code logDecorator}
   *   <li>Executes the provided {@code handler} to process the request
   *   <li>Handles success and error reporting to the {@code StreamObserver}
   * </ul>
   *
   * @param operation the name of the operation to trace and log
   * @param request the incoming gRPC request
   * @param observer the gRPC {@link StreamObserver} to send the response or error
   * @param handler the function that processes the request and returns a response
   * @param spanDecorator a consumer that enriches the created span with domain attributes
   * @param logDecorator a consumer that logs details of the request for observability
   * @param <RequestT> the type of the incoming request
   * @param <ResponseT> the type of the outgoing response
   * @author Jose Antonio (J4c62)
   * @since 2025-06-14
   */
  public <RequestT, ResponseT> void execute(
      String operation,
      RequestT request,
      StreamObserver<ResponseT> observer,
      Function<RequestT, ResponseT> handler,
      Consumer<Span> spanDecorator,
      Consumer<RequestT> logDecorator) {

    Span span =
        GlobalOpenTelemetry.get()
            .getTracer("booking-service")
            .spanBuilder(operation)
            .setSpanKind(SpanKind.SERVER)
            .startSpan();

    try (Scope ignored = span.makeCurrent()) {
      span.setAttribute("grpc.operation", operation);
      spanDecorator.accept(span);
      logDecorator.accept(request);

      span.addEvent("Handling request");
      ResponseT response = handler.apply(request);

      span.addEvent("Sending response");
      observer.onNext(response);
      observer.onCompleted();

    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, "Exception during gRPC call");
      log.error("[gRPC] {} failed: {}", operation, t.getMessage(), t);
      observer.onError(t);
    } finally {
      span.end();
    }
  }
}

package com.github.j4c62.pms.booking;

import static com.github.j4c62.pms.booking.domain.aggregate.creation.BookingEventFactory.createConfirmedBookingEvent;
import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingConfirmedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingUpdateEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.driven.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.driven.BookingEventStore;
import com.github.j4c62.pms.booking.infrastructure.adapter.driven.KafkaProducerAdapter;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.BookingServiceGrpc;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CancelBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.CreateBookingRequest;
import com.github.j4c62.pms.booking.infrastructure.provider.grpc.UpdateBookingRequest;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.KafkaStreams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@ImportTestcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(
    properties = {
      "grpc.server.inProcessName=flowTest",
      "grpc.server.port=-1",
      "grpc.client.inProcess.address=in-process:flowTest"
    })
@Import({AggregateFixture.class, KafkaProducerAdapter.class})
class BookingApplicationServiceTest {

  private static final KafkaContainer kafka =
      new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka"))
          .withStartupTimeout(Duration.ofSeconds(60));
  private static String createdBookingId;

  @GrpcClient("inProcess")
  private BookingServiceGrpc.BookingServiceBlockingStub bookingServiceGrpc;

  @Autowired private BookingEventStore bookingEventStore;
  @Autowired private StreamsBuilderFactoryBean streamsBuilderFactoryBean;
  @Autowired private BookingEventPublisher bookingEventPublisher;

  @BeforeAll
  static void setUpKafka() throws Exception {
    kafka.start();
    var store = "%s/booking-events-store-dev".formatted(System.getProperty("java.io.tmpdir"));
    System.setProperty("spring.kafka.bootstrap-servers", kafka.getBootstrapServers());
    System.setProperty("spring.kafka.streams.bootstrap-servers", kafka.getBootstrapServers());
    System.setProperty("spring.kafka.streams.state-dir", store);
    System.setProperty("application.booking.kafka.store-name", "booking-events-store-dev");

    try (AdminClient adminClient =
        AdminClient.create(
            Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers()))) {

      List<NewTopic> topics =
          List.of(
              new NewTopic("booking.created", 1, (short) 1),
              new NewTopic("booking.updated", 1, (short) 1),
              new NewTopic("booking.cancelled", 1, (short) 1),
              new NewTopic("booking.confirmed", 1, (short) 1));

      adminClient.createTopics(topics).all().get(10, TimeUnit.SECONDS);
    }
  }

  @Test
  @Order(1)
  void contextLoads(ApplicationContext context) {
    assertThat(context).as("Application context should be initialized").isNotNull();
    await()
        .atMost(Duration.ofSeconds(20))
        .untilAsserted(
            () -> {
              var kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
              assertThat(requireNonNull(kafkaStreams).state())
                  .as("Kafka Streams should be in RUNNING state")
                  .isEqualTo(KafkaStreams.State.RUNNING);
            });
  }

  @Test
  @Order(2)
  void givenGuestBookingWhenGuestDoesTheBookingThenBookingIsDoneAndGuestIsNotified(
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

    var booking = bookingServiceGrpc.createBooking(createBookingRequest);
    createdBookingId = booking.getBookingId();
    assertThat(createdBookingId).as("Created booking ID should not be null").isNotNull();
    await()
        .atMost(Duration.ofSeconds(40))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null for created booking").isNotNull();
              assertThat(events.events())
                  .as("First event should be BookingCreatedEvent")
                  .element(0)
                  .isExactlyInstanceOf(BookingCreatedEvent.class);
            });
  }

  @Test
  @Order(3)
  void givenGuestUpdateDatesWhenGuestUpdateDatesThenBookingIsUpdateAndGuestIsNotified(
      @Autowired BookingDates bookingDates, @Autowired GuestId guestId) {
    await()
        .atMost(Duration.ofSeconds(10))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null before updating").isNotNull();
              assertThat(events.events())
                  .as("Events list should not be empty before updating")
                  .isNotEmpty();
            });

    var updateBookingRequest =
        UpdateBookingRequest.newBuilder()
            .setBookingId(createdBookingId)
            .setGuestId(guestId.value().toString())
            .setNewStartDate(bookingDates.startDate().toString())
            .setNewEndDate(bookingDates.endDate().plusDays(3).toString())
            .setUpdateReason("Change of plans")
            .build();

    var booking = bookingServiceGrpc.updateBooking(updateBookingRequest);
    assertThat(booking.getBookingId())
        .as("Updated booking ID should match the original")
        .isEqualTo(createdBookingId);
    await()
        .atMost(Duration.ofSeconds(40))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null after updating").isNotNull();
              assertThat(events.events())
                  .element(1)
                  .as("Second event should be BookingUpdateEvent")
                  .isExactlyInstanceOf(BookingUpdateEvent.class);
            });
  }

  @Test
  @Order(4)
  void givenPaymentIsSuccessWhenGuestBookingThenBookingIsConfirmedAndGuestIsNotified() {
    await()
        .atMost(Duration.ofSeconds(10))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null before updating").isNotNull();
              assertThat(events.events())
                  .as("Events list should not be empty before updating")
                  .isNotEmpty();
            });

    bookingEventPublisher.publish(
        createConfirmedBookingEvent(BookingId.of(UUID.fromString(createdBookingId))));
    await()
        .atMost(Duration.ofSeconds(40))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null after updating").isNotNull();
              assertThat(events.events())
                  .as("Second event should be BookingUpdateEvent")
                  .element(2)
                  .isExactlyInstanceOf(BookingConfirmedEvent.class);
            });
  }

  @Test
  @Order(5)
  void givenGuestCancelBookingWhenGuestCancelTheBookingThenBookingIsCancelAndGuestIsNotified(
      @Autowired GuestId guestId) {
    await()
        .atMost(Duration.ofSeconds(10))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null before cancellation").isNotNull();
              assertThat(events.events())
                  .as("Events list should not be empty before cancellation")
                  .isNotEmpty();
            });
    var cancelBookingRequest =
        CancelBookingRequest.newBuilder()
            .setBookingId(createdBookingId)
            .setGuestId(guestId.value().toString())
            .setReason("Change of plans")
            .build();

    var booking = bookingServiceGrpc.cancelBooking(cancelBookingRequest);
    assertThat(booking.getBookingId())
        .as("Cancelled booking ID should match the original")
        .isEqualTo(createdBookingId);
    await()
        .atMost(Duration.ofSeconds(40))
        .untilAsserted(
            () -> {
              var events =
                  bookingEventStore.getEventsForBooking(
                      BookingId.of(UUID.fromString(createdBookingId)));
              assertThat(events).as("Events should not be null after cancellation").isNotNull();
              assertThat(events.events())
                  .as("Fourth event should be BookingCancelledEvent")
                  .element(3)
                  .isExactlyInstanceOf(BookingCancelledEvent.class);
            });
  }
}

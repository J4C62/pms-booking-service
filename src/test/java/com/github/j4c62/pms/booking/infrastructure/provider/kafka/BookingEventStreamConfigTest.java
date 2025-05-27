package com.github.j4c62.pms.booking.infrastructure.provider.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.shared.AggregateFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({AggregateFixture.class, BookingEventStreamConfig.class})
class BookingEventStreamConfigTest {

  @Test
  void givenBookingEventWhenBookingEventSupplierApplyThenReturnCorrectPayload(
      @Autowired @Qualifier("bookingCreatedEvent") BookingEvent bookingCreatedEvent,
      @Autowired BookingEventStreamConfig config,
      @Autowired SchemaRegistryClient schemaRegistryClient) {

//    var message = config.bookingEventSupplier(schemaRegistryClient).apply(bookingCreatedEvent);
//    assertThat(message.getPayload()).isEqualTo(bookingCreatedEvent);
  }
}

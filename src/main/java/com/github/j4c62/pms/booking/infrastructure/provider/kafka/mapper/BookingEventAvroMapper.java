package com.github.j4c62.pms.booking.infrastructure.provider.kafka.mapper;

import com.github.j4c62.pms.booking.BookingCancelledEventDTO;
import com.github.j4c62.pms.booking.BookingConfirmedEventDTO;
import com.github.j4c62.pms.booking.BookingCreatedEventDTO;
import com.github.j4c62.pms.booking.BookingEventTypeDTO;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCancelledEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingConfirmedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingCreatedEvent;
import com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEventType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface BookingEventAvroMapper {

  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "bookingIdBuilder", ignore = true)
  BookingCancelledEventDTO mapToAvro(BookingCancelledEvent domain);

  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "bookingIdBuilder", ignore = true)
  BookingConfirmedEventDTO mapToAvro(BookingConfirmedEvent domain);

  @Mapping(target = "eventType", source = "eventType")
  @Mapping(target = "bookingIdBuilder", ignore = true)
  @Mapping(target = "propertyIdBuilder", ignore = true)
  @Mapping(target = "guestIdBuilder", ignore = true)
  @Mapping(target = "bookingDatesBuilder", ignore = true)
  BookingCreatedEventDTO mapToAvro(BookingCreatedEvent domain);

  @ValueMappings({
    @ValueMapping(source = "BOOKING_CREATED", target = "BOOKING_CREATED"),
    @ValueMapping(source = "BOOKING_UPDATED", target = "BOOKING_UPDATED"),
    @ValueMapping(source = "BOOKING_CONFIRMED", target = "BOOKING_CONFIRMED"),
    @ValueMapping(source = "BOOKING_CANCELLED", target = "BOOKING_CANCELLED"),
  })
  BookingEventTypeDTO mapToAvro(BookingEventType domain);

  default Object mapToAvro(BookingEvent event) {
    return switch (event) {
      case BookingCancelledEvent e -> mapToAvro(e);
      case BookingConfirmedEvent e -> mapToAvro(e);
      case BookingCreatedEvent e -> mapToAvro(e);
      default ->
          throw new IllegalArgumentException("Unsupported BookingEvent type: " + event.getClass());
    };
  }
}

package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.adapter.gateway.entity.BookingEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

  BookingEntity toEntity(Booking booking);

  Booking toDomain(BookingEntity entity);
}

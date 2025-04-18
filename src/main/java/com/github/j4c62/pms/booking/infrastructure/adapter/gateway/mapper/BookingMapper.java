package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.mapper;

import com.github.j4c62.pms.booking.domain.model.Booking;
import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

  BookingEntity toEntity(Booking booking);

  Booking toDomain(BookingEntity entity);
}

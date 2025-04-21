package com.github.j4c62.pms.booking.domain.gateway.event;

import java.util.UUID;

public record BookingCreatedEvent(
    UUID bookingId, UUID propertyId, UUID guestId, String startDate, String endDate) {}

package com.github.j4c62.pms.booking.domain.gateway.event;

import java.util.UUID;

public record BookingUpdatedEvent(
    UUID bookingId, String newStartDate, String newEndDate, String updateReason, String updateAt) {}

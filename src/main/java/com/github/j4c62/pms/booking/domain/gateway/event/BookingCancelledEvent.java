package com.github.j4c62.pms.booking.domain.gateway.event;

import java.util.UUID;

public record BookingCancelledEvent(
    UUID bookingId, String reason, String cancelledBy, String cancelledAt) {}

package com.github.j4c62.pms.booking.domain.gateway.event;

public record BookingCancelled(
    String bookingId,
    String propertyId,
    String startDate,
    String endDate,
    String reason,
    String cancelledBy,
    String cancelledAt) {}

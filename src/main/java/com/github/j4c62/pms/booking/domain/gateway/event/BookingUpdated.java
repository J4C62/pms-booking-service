package com.github.j4c62.pms.booking.domain.gateway.event;

public record BookingUpdated(
    String bookingId,
    String oldStartDate,
    String oldEndDate,
    String newStartDate,
    String newEndDate,
    String updatedAt,
    String updateReason) {}

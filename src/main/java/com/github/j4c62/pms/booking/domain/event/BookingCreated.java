package com.github.j4c62.pms.booking.domain.event;

public record BookingCreated(
    String bookingId, String propertyId, String guestId, String startDate, String endDate) {}

package com.github.j4c62.pms.booking.application.dto;

public record CreateBookingCommand(
    String propertyId, String guestId, String startDate, String endDate) {}

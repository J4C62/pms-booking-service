package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.request.CreateBookingRequest;

public record CreateBookingCommand(
    String propertyId, String guestId, String startDate, String endDate)
    implements CreateBookingRequest {}

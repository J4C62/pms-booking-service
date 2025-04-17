package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.request.CancelBookingRequest;

public record CancelBookingCommand(
    String bookingId, String reason, String cancelledBy, String cancelledAt)
    implements CancelBookingRequest {}

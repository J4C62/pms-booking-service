package com.github.j4c62.pms.booking.application.command;

import com.github.j4c62.pms.booking.domain.driver.request.UpdateBookingRequest;

public record UpdateBookingCommand(
    String bookingId, String newStartDate, String newEndDate, String updateReason)
    implements UpdateBookingRequest {}

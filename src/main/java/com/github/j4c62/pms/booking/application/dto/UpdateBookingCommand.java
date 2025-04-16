package com.github.j4c62.pms.booking.application.dto;

public record UpdateBookingCommand(String newStartDate, String newEndDate, String updateReason) {}

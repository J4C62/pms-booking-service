package com.github.j4c62.pms.booking.domain.driver.output;

import com.github.j4c62.pms.booking.domain.model.BookingStatus;

public record BookingOutput(String bookingId, BookingStatus status) {}

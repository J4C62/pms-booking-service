package com.github.j4c62.pms.booking.domain.driver.output;

import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import java.util.UUID;

public record BookingOutput(UUID bookingId, BookingStatus status) {}

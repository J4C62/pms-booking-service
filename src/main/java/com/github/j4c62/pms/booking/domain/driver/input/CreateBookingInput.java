package com.github.j4c62.pms.booking.domain.driver.input;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;

public record CreateBookingInput(
    PropertyId propertyId, GuestId guestId, BookingDates bookingDates) {}

package com.github.j4c62.pms.booking.domain.aggregate.event;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;

public record BookingSnapshot(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    BookingStatus status) {}

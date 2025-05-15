package com.github.j4c62.pms.booking.domain.driver.output;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;

/**
 * Represents the result of executing a {@link
 * com.github.j4c62.pms.booking.domain.driver.command.Command} on a {@link
 * com.github.j4c62.pms.booking.domain.aggregate.BookingAggregate}.
 *
 * <p>This output is returned by command handlers to expose key information about the booking's
 * state after applying a command, typically including the booking's unique identifier and its
 * current status.
 *
 * <p>This DTO is intended for use at application or API boundaries and does not expose internal
 * domain logic.
 *
 * @param bookingId the unique identifier of the booking
 * @param status the current status of the booking (e.g., PENDING, CONFIRMED, CANCELLED)
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-04-18
 */
public record BookingOutput(BookingId bookingId, BookingStatus status) {}

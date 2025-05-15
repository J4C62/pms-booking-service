package com.github.j4c62.pms.booking.domain.aggregate.vo;

/**
 * Enumeration representing the types of domain events that can occur for a booking.
 *
 * <p>Each enum constant is associated with a string identifier, typically used for serialization,
 * deserialization, or message publishing (e.g., Kafka topics).
 *
 * <ul>
 *   <li>{@link #BOOKING_CREATED} - Indicates that a booking was created.
 *   <li>{@link #BOOKING_UPDATED} - Indicates that a booking's dates or details were updated.
 *   <li>{@link #BOOKING_CONFIRMED} - Indicates that a booking was confirmed by the system.
 *   <li>{@link #BOOKING_CANCELLED} - Indicates that a booking was cancelled.
 * </ul>
 *
 * @author Jose Antonio (J4c62)
 * @version 1.0.0
 * @since 2025-03-25
 */
public enum BookingEventType {
  BOOKING_CREATED("booking.created"),
  BOOKING_UPDATED("booking.updated"),
  BOOKING_CONFIRMED("booking.confirmed"),
  BOOKING_CANCELLED("booking.cancelled");
  private final String eventType;

  BookingEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getEventType() {
    return eventType;
  }
}

package com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "booking_events")
@Data
@AllArgsConstructor
public class BookingEventEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private UUID bookingId;

  @Column(nullable = false)
  private String eventType;

  @Lob
  @Column(nullable = false)
  private String payload;

  @Column(nullable = false)
  private Instant occurredAt;

}


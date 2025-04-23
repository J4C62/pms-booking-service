package com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "booking_snapshots")
@Data
public class BookingSnapshotEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private UUID bookingId;

  @Lob
  @Column(nullable = false)
  private String snapshot;

  @Column(nullable = false)
  private Instant createdAt;
}

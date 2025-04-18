package com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity;

import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class BookingEntity {

  @Id private String bookingId;
  private String propertyId;
  private String guestId;
  private String startDate;
  private String endDate;

  @Enumerated(EnumType.STRING)
  private BookingStatus status;
}

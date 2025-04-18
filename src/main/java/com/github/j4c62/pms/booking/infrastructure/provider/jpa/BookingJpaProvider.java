package com.github.j4c62.pms.booking.infrastructure.provider.jpa;

import com.github.j4c62.pms.booking.infrastructure.provider.jpa.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpaProvider extends JpaRepository<BookingEntity, String> {}

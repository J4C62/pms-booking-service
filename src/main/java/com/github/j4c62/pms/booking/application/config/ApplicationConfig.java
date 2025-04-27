package com.github.j4c62.pms.booking.application.config;

import com.github.j4c62.pms.booking.domain.aggregate.snapshot.policy.SnapshotPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public SnapshotPolicy snapshotPolicy() {
    return new SnapshotPolicy();
  }
}

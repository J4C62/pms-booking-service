package com.github.j4c62.pms.booking;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(
    properties = {
      "spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false",
      "spring.jpa.hibernate.ddl-auto=none",
      "grpc.server.port=-1"
    })
@Slf4j
class BookingApplicationServiceTest {

  @Test
  void contextLoads(ApplicationContext context) {
    assertThat(context).isNotNull();
  }

  @Test
  void listBeans(ApplicationContext context) {
    Arrays.stream(context.getBeanDefinitionNames())
        .sorted()
        .forEach(beanName -> log.debug("Bean: {}", beanName));
  }
}

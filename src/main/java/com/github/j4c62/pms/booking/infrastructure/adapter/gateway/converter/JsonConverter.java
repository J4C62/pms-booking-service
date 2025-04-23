package com.github.j4c62.pms.booking.infrastructure.adapter.gateway.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonConverter {
  private final ObjectMapper objectMapper;

  public <T> String toJson(T obj) {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error serializing to JSON", e);
    }
  }

  public <T> T fromJson(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new RuntimeException("Error deserializing from JSON", e);
    }
  }
}

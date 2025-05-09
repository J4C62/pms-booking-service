package com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde;

import io.cloudevents.CloudEvent;
import io.cloudevents.kafka.CloudEventDeserializer;
import io.cloudevents.kafka.CloudEventSerializer;
import lombok.Generated;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class CloudEventSerde implements Serde<CloudEvent> {

  private final CloudEventSerializer serializer = new CloudEventSerializer();
  private final CloudEventDeserializer deserializer = new CloudEventDeserializer();

  @Override
  @Generated
  public Serializer<CloudEvent> serializer() {
    return serializer;
  }

  @Override
  public Deserializer<CloudEvent> deserializer() {
    return deserializer;
  }
}

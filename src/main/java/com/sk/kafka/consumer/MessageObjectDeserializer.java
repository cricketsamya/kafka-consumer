package com.sk.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageObjectDeserializer implements Deserializer<MessageObject> {
    private final static Logger LOG = LoggerFactory.getLogger(MessageObjectDeserializer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public MessageObject deserialize(String topic, byte[] data) {
        MessageObject object = null;
        try {
            object = objectMapper.readValue(data, MessageObject.class);
        } catch (Exception e) {
            LOG.error("Error in deserializing " + data, e);
        }
        return object;
    }

    @Override
    public void close() {
    }

}
package com.sk.kafka.consumer;

import com.sk.kafka.consumer.constants.KafkaConsumerConstants;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class MessageConsumer {
    public static Consumer<String, MessageObject> create() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConsumerConstants.BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConsumerConstants.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageObjectDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConsumerConstants.MAX_POLL_RECORDS);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaConsumerConstants.OFFSET_RESET_EARLIER);

        final Consumer<String, MessageObject> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(KafkaConsumerConstants.TOPIC_NAME));
        return consumer;
    }
}

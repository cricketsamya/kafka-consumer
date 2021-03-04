package com.sk.kafka.consumer.constants;

public interface KafkaConsumerConstants {
    //Multiple Brokers can be used comma separated
    String BROKERS = "localhost:9092";
    String TOPIC_NAME = "chat";
    //The consumer group id used to identify to which group this consumer belongs.
    String GROUP_ID_CONFIG = "consumerGroup";
    Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
    String OFFSET_RESET_EARLIER = "earliest";
    int MAX_POLL_RECORDS = 1;
    int CONSUMER_TIMEOUT = 1000;
}

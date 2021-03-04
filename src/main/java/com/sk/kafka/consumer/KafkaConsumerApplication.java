package com.sk.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {
    private final static Logger LOG = LoggerFactory.getLogger(KafkaConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
        LOG.info("Server Started");

        final SampleMessageConsumer sampleMessageConsumer = new SampleMessageConsumer();
        sampleMessageConsumer.consume();
        LOG.info("End of Consumer!");
    }


}

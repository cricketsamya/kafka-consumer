package com.sk.kafka.consumer;

import com.sk.kafka.consumer.constants.KafkaConsumerConstants;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sk.kafka.consumer.constants.KafkaConsumerConstants.CONSUMER_TIMEOUT;

public class SampleMessageConsumer {
    private final static Logger LOG = LoggerFactory.getLogger(SampleMessageConsumer.class);


    public void consume() {
        final Consumer<String, MessageObject> consumer = MessageConsumer.create();

        int noMessageFound = 0;

        while (true) {
            final ConsumerRecords<String, MessageObject> consumerRecords = consumer.poll(CONSUMER_TIMEOUT);
            if (consumerRecords.count() == 0) {
                noMessageFound++;
                if (noMessageFound > KafkaConsumerConstants.MAX_NO_MESSAGE_FOUND_COUNT) {
                    //If 100 times no messages retrieved consumer will break
                    break;
                }
                continue;
            }
            consumerRecords.forEach(record -> {
                LOG.info("Key : " + record.key() + " | " + "Value " + record.value() + " | " + "Partition " + record.partition() + " | " + "Offset " + record.offset());
            });

            // commits the offset of record to broker.
            consumer.commitAsync();
        }
        consumer.close();
    }
}

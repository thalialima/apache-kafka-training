package com.kafka.strconsumer.listeners;

import com.kafka.strconsumer.custom.StrConsumerCustomListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class StrConsumerListeners {

    private static final Logger LOG = LogManager.getLogger(StrConsumerListeners.class);

    @StrConsumerCustomListener(groupId = "group-1")
    public void listen(String message) {
        LOG.info("LISTEN ::: Received message: {} ", message);
        throw new IllegalArgumentException("Exception on listener");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        LOG.info("LOG ::: Received message: {} ", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validateMessagesContainerFactory")
    public void history(String message) {
        LOG.info("HISTORY ::: Received message: {} ", message);
    }
}

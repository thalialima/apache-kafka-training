package com.kafka.strconsumer.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class StrConsumerListeners {

    private static final Logger LOG = LogManager.getLogger(StrConsumerListeners.class);

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void listen(String message){
        LOG.info("Received message: {} ", message);
    }
}

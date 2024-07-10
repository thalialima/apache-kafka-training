package com.kafka.strproducer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StringProducerService {

    private static final Logger LOG = LogManager.getLogger(StringProducerService.class);


    @Resource
    public KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        LOG.info("Message: {} sent with success.", message);
                        LOG.info("Partition: {}", success.getRecordMetadata().partition());
                        LOG.info("Offset: {}", success.getRecordMetadata().offset());
                    }
                },
                error -> LOG.error("Error while sending message!")
        );
    }

}

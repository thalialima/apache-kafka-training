package com.kafka.strproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StringProducerService {

    @Resource
    public KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message);
    }

}

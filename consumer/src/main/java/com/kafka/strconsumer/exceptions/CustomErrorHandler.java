package com.kafka.strconsumer.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorHandler implements KafkaListenerErrorHandler {

    private static final Logger LOG = LogManager.getLogger(CustomErrorHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        LOG.error("ERROR HANDLER ::: Error captured!");
        LOG.info("Payload ::: {}", message.getPayload());
        LOG.info("Headers ::: {}", message.getHeaders());
        LOG.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
        LOG.info("Error Message ::: {}", e.getMessage());
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}

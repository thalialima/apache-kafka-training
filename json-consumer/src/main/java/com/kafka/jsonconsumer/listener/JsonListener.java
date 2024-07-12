package com.kafka.jsonconsumer.listener;

import com.kafka.jsonconsumer.model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class JsonListener {
    private static final Logger LOG = LogManager.getLogger(JsonListener.class);

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        LOG.info("Payment received: {}", payment);

        try {
            Thread.sleep(2000);
            LOG.info("Validating fraud...");
            LOG.info("Payment approved!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOG.error("Error during anti fraud validation, due to: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        try {
            Thread.sleep(3000);
            LOG.info("Creating PDF for payment: {}", payment.getId());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOG.error("Error during PDF generation, due to: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        try {
            Thread.sleep(3000);
            LOG.info("Sending email...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOG.error("Error during email generation, due to: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}

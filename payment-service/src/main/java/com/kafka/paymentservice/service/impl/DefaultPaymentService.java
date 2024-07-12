package com.kafka.paymentservice.service.impl;

import com.kafka.paymentservice.model.Payment;
import com.kafka.paymentservice.service.PaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;


@Service
public class DefaultPaymentService implements PaymentService {

    private static final Logger LOG = LogManager.getLogger(DefaultPaymentService.class);

    @Resource
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    public void sendPayment(Payment payment) {
        try {
            LOG.info("Payment received: {}", payment);
            Thread.sleep(1000);
            kafkaTemplate.send("payment-topic", payment);
            LOG.info("Sending payment...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.error("Error during send payment, due to: {}", e.getMessage());
        }

    }
}

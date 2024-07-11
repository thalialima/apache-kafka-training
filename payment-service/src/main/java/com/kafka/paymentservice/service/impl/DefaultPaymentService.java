package com.kafka.paymentservice.service.impl;

import com.kafka.paymentservice.model.Payment;
import com.kafka.paymentservice.service.PaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;



@Service
public class DefaultPaymentService implements PaymentService {

    private static final Logger LOG = LogManager.getLogger(DefaultPaymentService.class);

    @Override
    public void sendPayment(Payment payment) {
        LOG.info("PAYMENT_SERVICE Payment received: {}", payment);

    }
}

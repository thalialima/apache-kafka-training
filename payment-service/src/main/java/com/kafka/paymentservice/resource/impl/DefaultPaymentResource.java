package com.kafka.paymentservice.resource.impl;

import com.kafka.paymentservice.model.Payment;
import com.kafka.paymentservice.resource.PaymentResource;
import com.kafka.paymentservice.service.PaymentService;
import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/payments")
public class DefaultPaymentResource implements PaymentResource {

    @Resource
    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> doPayment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

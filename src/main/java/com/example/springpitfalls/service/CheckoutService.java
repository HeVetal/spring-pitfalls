package com.example.springpitfalls.service;

import com.example.springpitfalls.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final Map<String, PaymentGateway> paymentGateways;

    public String checkout(String provider, Long amount) {
        if (null == paymentGateways.get(provider)) {
            throw new IllegalArgumentException("Unknown provider: " + provider + ", available: " + paymentGateways.keySet());
        }
        return paymentGateways.get(provider).pay(amount);
    }

    public void printKey() {
        paymentGateways.keySet().forEach(System.out::println);
    }
}

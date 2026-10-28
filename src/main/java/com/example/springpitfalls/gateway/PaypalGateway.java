package com.example.springpitfalls.gateway;

import org.springframework.stereotype.Component;

@Component
public class PaypalGateway implements PaymentGateway{
    @Override
    public String pay(Long amount) {
        return PaypalGateway.class.toString();
    }
}

package com.example.springpitfalls.gateway;

import org.springframework.stereotype.Component;

@Component
public class StripeGateway implements PaymentGateway{

    @Override
    public String pay(Long amount) {
        return StripeGateway.class.toString();
    }
}

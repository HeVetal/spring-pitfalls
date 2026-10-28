package com.example.springpitfalls.gateway;


public interface PaymentGateway {
    String pay(Long amount);
}

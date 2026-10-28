package com.example.springpitfalls.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SelfCallService {

    private final PaymentTxWorker paymentTxWorker;


    public void outer(Long amount) {
        paymentTxWorker.inner(amount);
    }
}

package com.example.springpitfalls.service;

import com.example.springpitfalls.entity.Payment;
import com.example.springpitfalls.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class PaymentTxWorker {

    private final PaymentRepository repository;

    @Transactional
    public void inner(Long amount) {
        System.out.println("tx active: " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println(this.getClass());
        repository.save(Payment.builder().amount(amount).build());
        throw new IllegalStateException("boom in inner");
    }


}

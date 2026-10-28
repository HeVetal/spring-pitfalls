package com.example.springpitfalls.service;

import com.example.springpitfalls.entity.Payment;
import com.example.springpitfalls.repository.PaymentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional(rollbackFor = IOException.class)
    public void savePayment(Long amount) throws IOException {
        paymentRepository.save(Payment.builder().amount(amount).description("Добавить платеж").build());
        throw new IOException("boom");
    }
}

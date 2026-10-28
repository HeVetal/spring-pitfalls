package com.example.springpitfalls.repository;

import com.example.springpitfalls.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

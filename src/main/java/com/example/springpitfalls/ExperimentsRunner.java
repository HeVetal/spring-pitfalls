package com.example.springpitfalls;

import com.example.springpitfalls.repository.PaymentRepository;
import com.example.springpitfalls.service.CheckoutService;
import com.example.springpitfalls.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExperimentsRunner implements CommandLineRunner {
    private final CheckoutService checkoutService;
    private final PaymentService paymentService;
    private final PaymentRepository repository;

    public void experiment1() {
        checkoutService.printKey();

        System.out.println(checkoutService.checkout("paypalGateway", 10L));
        System.out.println(checkoutService.checkout("stripeGateway", 10L));

        try {
            checkoutService.checkout("unknown", 10L);
        } catch (IllegalArgumentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }
    }

    public void experiment2() {
        System.out.println("count до: " + repository.count());
        try {
            paymentService.savePayment(100L);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("count после: " + repository.count());
    }

    @Override
    public void run(String... args) throws Exception {
        experiment2();
    }
}

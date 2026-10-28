package com.example.springpitfalls;

import com.example.springpitfalls.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExperimentsRunner implements CommandLineRunner {
    private final CheckoutService checkoutService;

    @Override
    public void run(String... args) throws Exception {
        checkoutService.printKey();

        System.out.println(checkoutService.checkout("paypalGateway", 10L));
        System.out.println(checkoutService.checkout("stripeGateway", 10L));

        try {
            checkoutService.checkout("unknown", 10L);
        } catch (IllegalArgumentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }
    }
}

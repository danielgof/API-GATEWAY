package com.example.purchases;

import com.example.purchases.domain.Purchase;
import com.example.purchases.service.PurchaseServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class PurchasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchasesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PurchaseServiceImpl purchaseService) {
        return args -> {purchaseService.addPurchase(
                new Purchase(1L, 344.4, "US", "2022-09-05", "flight ticket"));
        };
    }
}

package com.ecommerce.grocery.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // Initial data can be inserted here if required.

    }
}
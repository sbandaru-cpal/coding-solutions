package com.cpal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TaxCalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaxCalculatorService.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TaxCalculatorService.class, args);

        LOGGER.info("Let's inspect the beans provided by Spring Boot:");
    }
}

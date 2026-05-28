package com.Bank.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Bank.app")
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
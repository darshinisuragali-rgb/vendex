package com.vendex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main entry point for Vendex Backend Application
 * 
 * Enterprise Spend Management Platform
 * Multi-tenant architecture with JWT authentication
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.vendex")
public class VendexApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendexApplication.class, args);
    }
}

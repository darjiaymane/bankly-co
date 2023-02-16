package com.m2.transactionsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class M2TransactionsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2TransactionsManagementApplication.class, args);
    }

}

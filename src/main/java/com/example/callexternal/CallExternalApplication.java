package com.example.callexternal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CallExternalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallExternalApplication.class, args);
    }

}

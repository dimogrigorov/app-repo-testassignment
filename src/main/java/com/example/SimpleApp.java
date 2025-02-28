package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleApp {
    public static void main(String[] args) {
        SpringApplication.run(SimpleApp.class, args);
    }
}

@RestController
@RequestMapping("/status")
class StatusController {
    @GetMapping
    public String getStatus() {
        return "Application is running!";
    }
}


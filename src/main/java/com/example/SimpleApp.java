package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class SimpleApp {
    public static void main(String[] args) {
        SpringApplication.run(SimpleApp.class, args);
    }
}

@RestController
@RequestMapping("/application")
class ApplicationController {

    @Value("${app.version:unknown}")
    private String appVersion;

    @GetMapping
    public String getAppInfo() {
        return "Application Version: " + appVersion;
    }
}


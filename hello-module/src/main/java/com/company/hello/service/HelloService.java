package com.company.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String buildMessage(String name) {
        String effective = (name == null || name.isBlank()) ? "World" : name.trim();
        return String.format("Hello, %s!", effective);
    }
}

package com.company.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService service = new HelloService();

    @Test
    @DisplayName("Returns World when name is null")
    void returnsWorldWhenNameNull() {
        assertEquals("Hello, World!", service.buildMessage(null));
    }

    @Test
    @DisplayName("Trims and uses provided name")
    void trimsAndUsesProvidedName() {
        assertEquals("Hello, Dani!", service.buildMessage("  Dani  "));
    }

    @Test
    @DisplayName("Returns World when name is blank")
    void returnsWorldWhenNameBlank() {
        assertEquals("Hello, World!", service.buildMessage("   "));
    }
}

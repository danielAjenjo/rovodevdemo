package com.company.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.hello.model.HelloResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloServiceTest {
  @Test
  @DisplayName("sayHello returns greeting with provided name")
  void sayHelloReturnsGreeting() {
    final HelloService service = new HelloService();

    final HelloResponse response = service.sayHello("Alice");

    assertEquals("Hello, Alice!", response.message());
  }

  @Test
  @DisplayName("sayHello handles empty name consistently (service should not trim)")
  void sayHelloHandlesAnyInput() {
    final HelloService service = new HelloService();

    final HelloResponse response = service.sayHello("  Bob  ");

    assertEquals("Hello,   Bob  !", response.message());
  }
}

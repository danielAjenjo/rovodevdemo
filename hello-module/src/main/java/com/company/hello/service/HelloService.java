package com.company.hello.service;

import com.company.hello.model.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
  public HelloResponse sayHello(final String name) {
    final String message = String.format("Hello, %s!", name);
    return new HelloResponse(message);
  }
}

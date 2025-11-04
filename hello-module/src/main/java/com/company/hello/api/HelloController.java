package com.company.hello.api;

import com.company.hello.model.HelloResponse;
import com.company.hello.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private final HelloService helloService;

  public HelloController(final HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/api/hello")
  public HelloResponse hello(@RequestParam(name = "name", required = false) final String name) {
    final String safeName = (name == null || name.isBlank()) ? "world" : name.trim();
    return helloService.sayHello(safeName);
  }
}

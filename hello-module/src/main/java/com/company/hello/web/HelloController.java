package com.company.hello.web;

import com.company.hello.model.HelloResponse;
import com.company.hello.service.HelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> hello(@RequestParam(name = "name", required = false) String name) {
        final String message = helloService.buildMessage(name);
        return ResponseEntity.ok(new HelloResponse(message));
    }
}

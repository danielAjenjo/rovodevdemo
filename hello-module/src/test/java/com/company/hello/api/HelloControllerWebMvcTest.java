package com.company.hello.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.hello.model.HelloResponse;
import com.company.hello.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerWebMvcTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private HelloService helloService;

  @Test
  void helloEndpointReturnsMessage() throws Exception {
    when(helloService.sayHello("Alice")).thenReturn(new HelloResponse("Hello, Alice!"));

    mockMvc
        .perform(get("/api/hello").param("name", "Alice"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("Hello, Alice!")));
  }

  @Test
  void helloEndpointDefaultsToWorld() throws Exception {
    when(helloService.sayHello("world")).thenReturn(new HelloResponse("Hello, world!"));

    mockMvc
        .perform(get("/api/hello"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("Hello, world!")));
  }
}

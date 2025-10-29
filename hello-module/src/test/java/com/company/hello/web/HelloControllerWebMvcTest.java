package com.company.hello.web;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.hello.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerWebMvcTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private HelloService helloService;

    @Test
    @DisplayName("GET /api/hello without name returns World")
    void getHelloDefault() throws Exception {
        when(helloService.buildMessage(null)).thenReturn("Hello, World!");

        mockMvc
                .perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", equalTo("Hello, World!")));
    }

    @Test
    @DisplayName("GET /api/hello?name=Dani returns personalized message")
    void getHelloWithName() throws Exception {
        when(helloService.buildMessage("Dani")).thenReturn("Hello, Dani!");

        mockMvc
                .perform(get("/api/hello").param("name", "Dani"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", equalTo("Hello, Dani!")));
    }
}

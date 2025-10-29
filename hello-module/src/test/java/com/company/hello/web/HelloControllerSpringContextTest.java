package com.company.hello.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerSpringContextTest {

    @Autowired private MockMvc mockMvc;

    @Test
    void contextLoadsAndDefaultHello() throws Exception {
        mockMvc
                .perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", equalTo("Hello, World!")));
    }
}

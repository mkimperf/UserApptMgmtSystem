package com.perficient.userservice.controller;

import com.perficient.userservice.service.UserCreateService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserDeleteController.class)
class UserDeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @BeforeAll
    public void setup() {
    }

    @Test
    void deleteUser() {
    }
}
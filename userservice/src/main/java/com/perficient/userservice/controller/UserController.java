package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.service.UserCreateService;
import com.perficient.userservice.service.UserGetService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/api/v1")
@RestController
public class UserController {
    @Autowired
    private UserCreateService createService;

    @Autowired
    private UserGetService getService;

    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> listUsers() {
        return Arrays.asList(new UserDto());
    }
}

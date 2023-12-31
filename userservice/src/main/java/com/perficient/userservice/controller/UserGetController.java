package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.service.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class UserGetController {
    @Autowired
    private UserGetService getService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto getUser(@PathVariable int id) {
        UserDto user = getService.getUser(id);
        return user;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> listUsers() {

        return getService.getUsers();
    }
}

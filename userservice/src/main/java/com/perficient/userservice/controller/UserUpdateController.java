package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.service.UserUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class UserUpdateController {
    @Autowired
    private UserUpdateService updateService;

    @PutMapping("/user/{id}")
    @ResponseBody
    public UserDto updateUser(@PathVariable int id, @Valid @RequestBody UserDto user) {
        UserDto updatedUser = updateService.updateUser(id, user);
        return updatedUser;
    }
}

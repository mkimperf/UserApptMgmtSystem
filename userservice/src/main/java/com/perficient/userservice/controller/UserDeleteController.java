package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.service.UserDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class UserDeleteController {

    @Autowired
    private UserDeleteService deleteService;
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable int id) {
        this.deleteService.deleteUser(id);
    }
}

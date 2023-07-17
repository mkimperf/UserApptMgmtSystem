package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.service.UserCreateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/api/v1")
@RestController
public class UserCreateController {

    @Autowired
    private UserCreateService createService;
    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto user) {
        User newUser = createService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

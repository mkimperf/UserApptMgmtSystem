package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {
    @Autowired
    private UserRepository repository;


    public User createUser(UserDto user) {
        User newUser = new User(user);
        return repository.save(newUser);
    }
}

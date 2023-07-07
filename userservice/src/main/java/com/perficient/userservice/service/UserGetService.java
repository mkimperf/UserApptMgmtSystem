package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGetService {
    @Autowired
    private UserRepository repository;


    public UserDto getUser(Integer id) {
        User user = repository.getById(id);
        return new UserDto(user);
    }
}
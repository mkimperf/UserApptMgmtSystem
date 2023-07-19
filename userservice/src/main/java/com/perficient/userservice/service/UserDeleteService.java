package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeleteService {
    @Autowired
    private UserRepository repository;

    public void deleteUser(Integer id) {
        try {
        	repository.deleteById(id);
        } catch (IllegalArgumentException ex) {
        	throw new UserNotFoundException("The user doesn't exist");
        }
        
    }
}

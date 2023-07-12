package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;

import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserUpdateService {
    @Autowired
    private UserRepository repository;

    private void update(UserDto user, User currUser) {
        currUser.setFirstName(user.getFirstName());
        currUser.setLastName(user.getLastName());
        currUser.setAge(user.getAge());
        currUser.setEmailAddress(user.getEmailAddress());
        currUser.setGender(user.getGender());
        currUser.setPhoneNumbers(user.getPhoneNumbers());
    }


    public UserDto updateUser(int id, UserDto user) {
        Optional<User> currUser = repository.findById(id);
        if (currUser.isEmpty()) throw new UserNotFoundException("The user doesn't exist");
        update(user, currUser.get());
        repository.save(currUser.get());
        return new UserDto(currUser.get());
    }
}

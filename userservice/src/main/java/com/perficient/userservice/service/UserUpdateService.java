package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User currUser = repository.getById(id);
        update(user, currUser);
        repository.save(currUser);
        return new UserDto(currUser);
    }
}

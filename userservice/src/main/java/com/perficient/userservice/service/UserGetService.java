package com.perficient.userservice.service;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserGetService {
    @Autowired
    private UserRepository repository;


    public UserDto getUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("The user doesn't exist");
        return new UserDto(user.get());
    }

    public List<UserDto> getUsers() {
        List<UserDto> res = repository.findAll().stream().
                map(sourceObj -> new UserDto(sourceObj)).collect(Collectors.toList());
        return res;
    }
}

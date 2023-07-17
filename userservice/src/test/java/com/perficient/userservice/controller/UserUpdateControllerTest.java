package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserGetService;
import com.perficient.userservice.service.UserUpdateService;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserUpdateControllerTest {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserUpdateController controller;


    @Test
    void updateUser() {
    	User user = new User(new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
    	repository.save(user);
    	UserDto userdto = new UserDto(user);
    	userdto.setAge(35);
    	controller.updateUser(user.getId(), userdto);
    	
    	assertEquals(repository.findById(user.getId()).get().getAge(), 35);
    }
    
    @Test
    void updateUserFail() {
    	try {
			controller.updateUser(0, new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
			fail("Didn't throw exception");
		} catch (UserNotFoundException exception ) {
			assertEquals(exception.getMessage(), "The user doesn't exist");
		}
    }
}
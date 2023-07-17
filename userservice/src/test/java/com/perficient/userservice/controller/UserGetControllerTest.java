package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserCreateService;
import com.perficient.userservice.service.UserGetService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserGetControllerTest {

    @Autowired
    private UserGetController controller;
    
    @Autowired
	private UserRepository repository;
	

    @Test
    void getUser() throws Exception {
    	User user = new User(new UserDto
    			("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
    	repository.save(user);
    	UserDto returnedUser = controller.getUser(user.getId());
    	
        assertEquals(user.getFirstName(), returnedUser.getFirstName());
        assertEquals(user.getLastName(), returnedUser.getLastName());
        assertEquals(user.getAge(), returnedUser.getAge());
        assertEquals(user.getEmailAddress(), returnedUser.getEmailAddress());
        assertEquals(user.getPhoneNumbers(), returnedUser.getPhoneNumbers());
        assertEquals(user.getGender(), returnedUser.getGender());
    }
    
    @Test
    void getUserFail() {
    	try {
			controller.getUser(0);
			fail("Didn't throw exception");
		} catch (UserNotFoundException exception ) {
			assertEquals(exception.getMessage(), "The user doesn't exist");
		}
    }

    @Test
    void listUsers() {

        User user1 = new User(new UserDto(
                "first", "last", "M", "test@perficient.com", "0000000000", 21));
        User user2 = new User(new UserDto(
                "first", "last", "M", "test@perficient.com", "0000000000", 21));
        
        repository.save(user1);
        repository.save(user2);
//        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        List<UserDto> list = controller.listUsers();

        assertEquals(user1.getFirstName(), list.get(0).getFirstName());
        assertEquals(user1.getLastName(), list.get(0).getLastName());
        assertEquals(user1.getAge(), list.get(0).getAge());
        assertEquals(user1.getEmailAddress(), list.get(0).getEmailAddress());
        assertEquals(user1.getPhoneNumbers(), list.get(0).getPhoneNumbers());
        assertEquals(user1.getGender(), list.get(0).getGender());

        assertEquals(user2.getFirstName(), list.get(1).getFirstName());
        assertEquals(user2.getLastName(), list.get(1).getLastName());
        assertEquals(user2.getAge(), list.get(1).getAge());
        assertEquals(user2.getEmailAddress(), list.get(1).getEmailAddress());
        assertEquals(user2.getPhoneNumbers(), list.get(1).getPhoneNumbers());
        assertEquals(user2.getGender(), list.get(1).getGender());
    }
}
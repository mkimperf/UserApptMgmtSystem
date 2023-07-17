package com.perficient.userservice.controller;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserCreateService;
import com.perficient.userservice.service.UserDeleteService;

import jakarta.transaction.Transactional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserDeleteControllerTest {

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserDeleteController controller;

	@Test
	void test() {
		
		UserDto userdto = new UserDto("test", "user", "M", "user@perficient.com", "0000000001", 25);
		User user = new User(userdto);
		
		repository.save(user);
		
		controller.deleteUser(user.getId());
		assertEquals(repository.count(), 0);
		
	}
	
	@Test
	void testFail() {
		try {
			controller.deleteUser(0);
			fail("No exception was thrown");
		} catch (UserNotFoundException exception) {
			assertEquals(exception.getMessage(), "The user doesn't exist");
		}
	}

}
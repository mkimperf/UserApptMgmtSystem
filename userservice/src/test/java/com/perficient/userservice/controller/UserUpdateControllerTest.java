package com.perficient.userservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserUpdateService;

@ExtendWith(MockitoExtension.class)
class UserUpdateControllerTest {

	@InjectMocks
	private UserUpdateController controller;
	
	@Mock
	private UserUpdateService service;
	
	@Test
	void test() {
		UserDto test = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);
		UserDto test2 = new UserDto("first1", "last1", "M", "test1@perficient.com", "0000000001", 23);
		when(service.updateUser(anyInt(), any())).thenReturn(test2);
		
		UserDto returnedUser = controller.updateUser(0, test);
		
		assertEquals(returnedUser.getFirstName(), test2.getFirstName());
		verify(service).updateUser(anyInt(), any());
	}
	

}

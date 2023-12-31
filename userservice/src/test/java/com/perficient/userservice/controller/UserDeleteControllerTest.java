package com.perficient.userservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.util.Optional;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserDeleteService;

@ExtendWith(MockitoExtension.class)
class UserDeleteControllerTest {

	@InjectMocks
	private UserDeleteController controller;
	
	@Mock
	private UserDeleteService service;
	
	@Test
	void test() {
		doNothing().when(service).deleteUser(anyInt());
		
		controller.deleteUser(0);
		verify(service).deleteUser(anyInt());
	}
	
	@Test
	void testException() {
		try {
			doThrow(new RuntimeException()).when(service).deleteUser(anyInt());
			controller.deleteUser(0);
			fail("Exception was not called");
		} catch(RuntimeException ex) {
			verify(service).deleteUser(anyInt());
		}
	}

}

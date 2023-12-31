package com.perficient.userservice.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;
import com.perficient.userservice.service.UserGetService;

@ExtendWith(MockitoExtension.class)
class UserGetControllerTest {
	
	@InjectMocks
	private UserGetController controller;
	
	@Mock
	private UserGetService service;

	@Test
	void testGetUser() {
		UserDto user = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);

		when(service.getUser(anyInt())).thenReturn(user);
		UserDto returned = controller.getUser(0);
		
		assertEquals(returned.getFirstName(), "first");
		verify(service).getUser(anyInt());
	}
	
	
	@Test
	void testGetAllUser() {
		
		UserDto user1 = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21),
				user2 = new UserDto("firstName", "lastName", "W", "test2@perficient.com", "0000000001", 25);
		List<UserDto> list = new ArrayList<UserDto>();
		list.add(user1);
		list.add(user2);
		
		when(service.getUsers()).thenReturn(list);
		List<UserDto> returned = controller.listUsers();
		
		assertEquals(returned.size(), 2);
		assertEquals(returned.get(0).getFirstName(), "first");
		assertEquals(returned.get(1).getLastName(), "lastName");
		verify(service).getUsers();
	}

}
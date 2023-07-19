package com.perficient.userservice.service;

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

@ExtendWith(MockitoExtension.class)
class UserGetServiceTest {
	
	@InjectMocks
	private UserGetService service;
	
	@Mock
	private UserRepository repository;

	@Test
	void testGetUser() {
		Optional<User> user = Optional.of(new User(1, "first", "last", "M", "test@perficient.com", "0000000000", 21));
//		UserDto user = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);
		when(repository.findById(anyInt())).thenReturn(user);
		UserDto returned = service.getUser(0);
		
		assertEquals(returned.getFirstName(), "first");
		verify(repository).findById(anyInt());
	}
	
	@Test
	void testGetUserFail() {
		Optional<User> user = Optional.empty();
		when(repository.findById(anyInt())).thenReturn(user);
		try {
			service.getUser(0);
			fail("Exception was not called");
		} catch (Exception ex) {
			verify(repository).findById(anyInt());
		}
	}
	
	@Test
	void testGetAllUser() {
		
		User user1 = new User(1,"first", "last", "M", "test@perficient.com", "0000000000", 21),
				user2 = new User(2,"firstName", "lastName", "W", "test2@perficient.com", "0000000001", 25);
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		
		when(repository.findAll()).thenReturn(list);
		List<UserDto> returned = service.getUsers();
		
		assertEquals(returned.size(), 2);
		assertEquals(returned.get(0).getFirstName(), "first");
		assertEquals(returned.get(1).getLastName(), "lastName");
		verify(repository).findAll();
	}

}

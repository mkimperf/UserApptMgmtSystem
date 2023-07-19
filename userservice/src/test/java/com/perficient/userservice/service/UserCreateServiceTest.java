package com.perficient.userservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserCreateServiceTest {
	
	@InjectMocks
	private UserCreateService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	void test() {
		User user = new User(1,"first", "last", "M", "test@perficient.com", "0000000000", 21);
		UserDto test = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);
		when(repository.save(any())).thenReturn(user);
		
		User returnedUser = service.createUser(test);
		
		assertEquals(returnedUser.getId(), user.getId());
		
		verify(repository).save(any());
	}

}

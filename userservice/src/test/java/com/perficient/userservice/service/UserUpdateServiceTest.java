package com.perficient.userservice.service;

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

@ExtendWith(MockitoExtension.class)
class UserUpdateServiceTest {

	@InjectMocks
	private UserUpdateService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	void test() {
		UserDto test = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);
		Optional<User> user = Optional.of(new User(1, "first", "last", "M", "test@perficient.com", "0000000000", 21));
		when(repository.findById(anyInt())).thenReturn(user);
		when(repository.save(any())).thenReturn(user.get());
		
		UserDto returnedUser = service.updateUser(0, test);
		
		assertEquals(returnedUser.getFirstName(), test.getFirstName());
		verify(repository).save(any());
		verify(repository).findById(anyInt());
	}
	
	
	@Test
	void testFail() {
		UserDto test = new UserDto("first", "last", "M", "test@perficient.com", "0000000000", 21);
		when(repository.findById(anyInt())).thenReturn(Optional.empty());
		try {
			service.updateUser(0, test);
			fail("Exception was not called");
		} catch (Exception ex) {
			verify(repository).findById(anyInt());
		}

	}

}

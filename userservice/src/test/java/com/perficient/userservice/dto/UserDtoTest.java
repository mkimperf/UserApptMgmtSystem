package com.perficient.userservice.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.perficient.userservice.entity.User;

class UserDtoTest {

	@Test
	void testUserDto() {
		UserDto user = new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21);
		assertEquals("firstName", user.getFirstName());
		assertEquals("lastName", user.getLastName());
		assertEquals("M", user.getGender());
		assertEquals("test@perficient.com", user.getEmailAddress());
		assertEquals("0000000000", user.getPhoneNumbers());
		assertEquals(21, user.getAge());

		user.setFirstName("first");
		assertEquals("first", user.getFirstName());
		user.setLastName("last");
		assertEquals("last", user.getLastName());
		user.setGender("W");
		assertEquals("W", user.getGender());
		user.setAge(25);
		assertEquals(25, user.getAge());
		user.setEmailAddress("set@perficient.com");
		assertEquals("set@perficient.com", user.getEmailAddress());
		user.setPhoneNumbers("1111111111");
		assertEquals("1111111111", user.getPhoneNumbers());
		
		User userobj = new User(0, "test", "user", "M", "user@perficient.com", "0000000001", 25);
		user = new UserDto(userobj);
		assertEquals("test", user.getFirstName());
		assertEquals("user", user.getLastName());
		assertEquals("M", user.getGender());
		assertEquals("user@perficient.com", user.getEmailAddress());
		assertEquals("0000000001", user.getPhoneNumbers());
		assertEquals(25, user.getAge());
	}
}

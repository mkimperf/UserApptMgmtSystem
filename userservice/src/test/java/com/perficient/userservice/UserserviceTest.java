package com.perficient.userservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.perficient.userservice.controller.UserCreateController;
import com.perficient.userservice.controller.UserDeleteController;
import com.perficient.userservice.controller.UserGetController;
import com.perficient.userservice.controller.UserUpdateController;
import com.perficient.userservice.dto.UserDto;
import com.perficient.userservice.entity.User;
import com.perficient.userservice.exception.UserNotFoundException;
import com.perficient.userservice.repository.UserRepository;

import jakarta.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserserviceTest {
	
	@Autowired
    UserCreateController createController;
	
	@Autowired
	UserGetController getController;
	
	@Autowired
	UserDeleteController deleteController;
	
	@Autowired
	UserUpdateController updateController;

    @Autowired
    UserRepository repository;
    
    
	@Test
	void createUserTest() {
		UserDto userdto = new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21);
		createController.createUser(userdto);
		assertEquals(repository.count(), 1);
	}
	
	@Test
	void deleteUserTest() {
		UserDto userdto = new UserDto("test", "user", "M", "user@perficient.com", "0000000001", 25);
		User user = new User(userdto);
		
		repository.save(user);
		
		deleteController.deleteUser(user.getId());
		assertEquals(repository.count(), 0);
	}
	
	
	@Test
    void getUser() throws Exception {
    	User user = new User(new UserDto
    			("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
    	repository.save(user);
    	UserDto returnedUser = getController.getUser(user.getId());
    	
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
			getController.getUser(0);
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
        List<UserDto> list = getController.listUsers();

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
    
    @Test
    void updateUser() {
    	User user = new User(new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
    	repository.save(user);
    	UserDto userdto = new UserDto(user);
    	userdto.setAge(35);
    	updateController.updateUser(user.getId(), userdto);
    	
    	assertEquals(repository.findById(user.getId()).get().getAge(), 35);
    }
    
    @Test
    void updateUserFail() {
    	try {
			updateController.updateUser(0, new UserDto("firstName", "lastName", "M", "test@perficient.com", "0000000000", 21));
			fail("Didn't throw exception");
		} catch (UserNotFoundException exception ) {
			assertEquals(exception.getMessage(), "The user doesn't exist");
		}
    }

}

package com.perficient.userservice.entity;

import com.perficient.userservice.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="user_data")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @Email
    private String emailAddress;
    
    public User() {
    	
    }
    
    public User(Integer id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String gender,
			@Email String emailAddress, @Size(min = 10, max = 10) String phoneNumbers,
			@Digits(integer = 3, fraction = 0) Integer age) {
//		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.phoneNumbers = phoneNumbers;
		this.age = age;
	}

	@Size(min=10, max=10)
    private String phoneNumbers;
    @Digits(integer = 3, fraction = 0)
    private Integer age;

    public User(UserDto user) {
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setGender(user.getGender());
        this.setPhoneNumbers(user.getPhoneNumbers());
        this.setEmailAddress(user.getEmailAddress());
        this.setAge(user.getAge());
    }


}
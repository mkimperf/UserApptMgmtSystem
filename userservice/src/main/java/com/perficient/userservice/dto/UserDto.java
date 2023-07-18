package com.perficient.userservice.dto;

import com.perficient.userservice.entity.User;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserDto {

	@NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @NotBlank
    private String emailAddress;

	@NotBlank
    private String phoneNumbers;
    @NotNull
    @Digits(integer = 3, fraction = 0)
    private Integer age;
    
    public UserDto() {
    	
    }
    
    public UserDto(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String gender,
			@NotBlank String emailAddress, @NotBlank String phoneNumbers,
			@NotNull @Digits(integer = 3, fraction = 0) Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.phoneNumbers = phoneNumbers;
		this.age = age;
	}

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.gender = user.getGender();
        this.emailAddress = user.getEmailAddress();
        this.phoneNumbers = user.getPhoneNumbers();
        this.age = user.getAge();
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

}
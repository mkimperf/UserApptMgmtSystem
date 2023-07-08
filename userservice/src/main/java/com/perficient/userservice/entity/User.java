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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user_data")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @Email
    private String emailAddress;
    @Size(min=10, max=10)
    private String phoneNumbers;
    @Digits(integer = 3, fraction = 0)
    private Integer age;

    public User(UserDto user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.emailAddress = user.getEmailAddress();
        this.phoneNumbers = user.getPhoneNumbers();
    }


}
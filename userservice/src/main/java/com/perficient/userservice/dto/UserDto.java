package com.perficient.userservice.dto;

import com.perficient.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String emailAddress;
    private String phoneNumbers;
    private Integer age;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.gender = user.getGender();
        this.emailAddress = user.getEmailAddress();
        this.phoneNumbers = user.getPhoneNumbers();
        this.age = user.getAge();
    }


}
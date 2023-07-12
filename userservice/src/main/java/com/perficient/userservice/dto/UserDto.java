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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.gender = user.getGender();
        this.emailAddress = user.getEmailAddress();
        this.phoneNumbers = user.getPhoneNumbers();
        this.age = user.getAge();
    }


}
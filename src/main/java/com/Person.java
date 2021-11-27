package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @NotNull(message = "Name cannot be null")
    private String firstName;
    @Size(min = 2, max = 30)
    private String lastName;
    @Pattern(regexp="^[\\d\\(\\)\\-+ ]+$", message="Phone should be valid")
    private String phone;
    @Email(message = "Email should be valid")
    private String email;

}

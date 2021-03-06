package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @NotNull(message = "Name cannot be null")
    private String firstName;
    @Size(min = 2, max = 30)
    private String lastName;
    @Pattern(regexp = "^[\\d\\(\\)\\-+ ]+$", message = "Phone should be valid")
    private String phone;
    @Email(message = "Email should be valid")
    private String email;

}

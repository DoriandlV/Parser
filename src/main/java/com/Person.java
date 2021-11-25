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
public class Person implements Validator {

    PersonValidator validator;

    @NotNull(message = "Name cannot be null")
    private String firstName;
    @Size(min = 2, max = 30)
    private String lastName;
    @Pattern(regexp = "(\"^(\\\\+7\\\\d{1,3}( )?)?((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$\")")
    private String phone;
    @Email(message = "Email should be valid", regexp = "^(.+)@(\\S+) $.")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
if (email != null) {

}
    }
}

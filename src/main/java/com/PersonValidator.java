package com;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person p = (Person) target;
        if (p.getFirstName() != null) {

        } else {
            errors.rejectValue("firstName", "", "should not be empty");
        }

        if (p.getEmail() != null) {
            errors.rejectValue("email", "", "format");

        } else {

        }
    }
}

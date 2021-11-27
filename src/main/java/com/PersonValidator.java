package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PersonValidator  {

    @Autowired
    private Validator validator;

    public Person validate (Person person) {
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        List<String> violations = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        List<Object> violationsValue = constraintViolations.stream().map(ConstraintViolation::getInvalidValue).collect(Collectors.toList());

        return person;
    }

}

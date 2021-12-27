package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class Runner {

    @Autowired
    private Parser parser;
    @Autowired
    private FileConfiguration fileConfiguration;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonPrinter personPrinter;
    @Autowired
    private Validator validator;

    @SneakyThrows
    public void run() {

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> jsonFiles = fileConfiguration.getPaths();
        System.out.println(jsonFiles);

        for (String json : jsonFiles) {

            InputStream input = Runner.class.getClassLoader().getResourceAsStream(json);

            Person person = objectMapper.readValue(input, Person.class);

            Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

            List<String> violations = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

            List<Object> violationsValue = constraintViolations.stream().map(ConstraintViolation::getInvalidValue).collect(Collectors.toList());

            if (constraintViolations.isEmpty()) {

                personRepository.save(person);
                personPrinter.printer(person);

            } else {

                System.out.println("");
                System.out.println("ERROR ARE PRESENT");
                System.out.println(violations + ":" + violationsValue.toString());
                personPrinter.printer(person);
            }

        }


    }
}

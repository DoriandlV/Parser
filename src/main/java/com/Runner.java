package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.*;

import java.util.List;
import java.util.Set;

@Service

public class Runner {

    @Autowired
    private  Parser parser;
    @Autowired
    private  FileConfiguration fileConfiguration;
    @Autowired
    private PersonRepository pRepository;
    @Autowired
    private Validator validator;

    public String filePath = "C:\\Users\\Umberto\\Documents\\MAX\\Parser\\src\\main\\resources";
   // String path = Runner.class.getClassLoader().getResource(".json").getPath();
   // String pathBis = Runner.class.getClassLoader().getResource(".json").getPath();
   // getResource("bar.txt");
    // getClassLoader().getResource("foo/bar.txt");
   // InputStream inputStream = Runner.class.getClassLoader().getResourceAsStream(String.valueOf(fileConfiguration.getPaths()));

    public Runner() {
    }

    @SneakyThrows
    public void run() {
        //System.out.println(path);
        //System.out.println(pathBis);
        //System.out.println(inputStream);

        System.out.println(fileConfiguration.getPaths());

        ObjectMapper objectMapper = new ObjectMapper();

        List<String> jsonFiles = parser.parse(filePath);
        for (String json : jsonFiles) {

            InputStream input = new FileInputStream(json);

            Person person = objectMapper.readValue(input, Person.class);

            Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

            pRepository.save(person);

            System.out.println(constraintViolations);
            System.out.println("FirstName : " + person.getFirstName());
            System.out.println("LastName  : " + person.getLastName());
            System.out.println("Phone     : " + person.getPhone());
            System.out.println("Email     : " + person.getEmail());
        }

    }
}

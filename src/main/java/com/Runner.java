package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.List;

@Service
public class Runner implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com");
        Parser parser = context.getBean(Parser.class);

        String filePath = "C:\\Users\\Umberto\\Documents\\MAX\\Parser\\src\\main\\resources";
        ObjectMapper objectMapper = new ObjectMapper();

        List<String> jsonFiles = parser.parse(filePath);
        for (String json : jsonFiles) {

            InputStream input = new FileInputStream(json);

            Person person = objectMapper.readValue(input, Person.class);

            System.out.println("");
            System.out.println("FirstName : " + person.getFirstName());
            System.out.println("LastName  : " + person.getLastName());
            System.out.println("Phone     : " + person.getPhone());
            System.out.println("Email     : " + person.getEmail());
        }

    }
}

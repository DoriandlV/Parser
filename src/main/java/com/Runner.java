package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

import java.util.List;

@Service

public class Runner {

    @Autowired
    private  Parser parser;
    @Autowired
    private  FileConfiguration fileConfiguration;

    public String filePath = "C:\\Users\\Umberto\\Documents\\MAX\\Parser\\src\\main\\resources";
   // String path = Runner.class.getClassLoader().getResource(".json").getPath();


   // InputStream inputStream = Runner.class.getClassLoader().getResourceAsStream(String.valueOf(fileConfiguration.getPaths()));

    public Runner() {
    }

    @SneakyThrows
    public void run() {
        //System.out.println(path);
        //System.out.println(inputStream);
        System.out.println(fileConfiguration.getPaths());

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

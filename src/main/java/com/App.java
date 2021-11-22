package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class App {

        public static void main(String args[]) throws IOException {

                ApplicationContext context = new AnnotationConfigApplicationContext("com");
                Person person = context.getBean(Person.class);
                Parser parser = context.getBean(Parser.class);
                //FileConfig config = context.getBean(FileConfig.class);



                List<String> jsonfiles = parser.parse("C:\\Users\\Umberto\\Documents\\MAX\\Parser\\src\\main\\resources");

                for (String s: jsonfiles) {

                    ObjectMapper objectMapper = new ObjectMapper();

                    InputStream input = new FileInputStream(s);

                        person = objectMapper.readValue(input, Person.class);

                        System.out.println("FirstName :" + person.getFirstName());
                        System.out.println("LastName :" + person.getLastName());
                        System.out.println("Phone :" + person.getPhone());
                        System.out.println("Email :" + person.getEmail());
                }

        }
}

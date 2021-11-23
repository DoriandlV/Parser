package com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class App {

        public static void main(String args[]) throws IOException{

                ApplicationContext context = new AnnotationConfigApplicationContext("com");
                Runner t1 = context.getBean(Runner.class);

                t1.run();

        }
}

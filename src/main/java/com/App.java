package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

        public static void main(String args[]){

                ApplicationContext context = new AnnotationConfigApplicationContext("com");
                Runner t1 = context.getBean(Runner.class);

                t1.run();

        }
}

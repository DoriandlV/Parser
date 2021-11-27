package com;

import org.springframework.stereotype.Service;

@Service
public class PersonPrinter {

   public Person printer (Person person){

       System.out.println("");
       System.out.println("FirstName : " + person.getFirstName());
       System.out.println("LastName  : " + person.getLastName());
       System.out.println("Phone     : " + person.getPhone());
       System.out.println("Email     : " + person.getEmail());

       return person;
    }
}

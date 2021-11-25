package com;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    List <Person> people = new ArrayList<>();

    public List<Person> getUsers(){
        return people;
    }
    public Person save(Person person){
        people.add(person);
        return person;
    }


}

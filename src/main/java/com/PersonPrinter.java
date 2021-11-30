package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

/*@Configuration
@PropertySource("classpath:application.properties") */
@Service
public class PersonPrinter {

    ExpressionParser expressionParser = new SpelExpressionParser();

    Expression firstName = expressionParser.parseExpression("firstName");
    Expression lastName = expressionParser.parseExpression("lastName");
    Expression phone = expressionParser.parseExpression("phone");
    Expression email = expressionParser.parseExpression("email");


    public Person printer (Person person){

        EvaluationContext context = new StandardEvaluationContext(person);
        System.out.println("");

        System.out.println("FirstName : " + firstName.getValue(context));
        System.out.println("LastName  : " + lastName.getValue(context));
        System.out.println("Phone     : " + phone.getValue(context));
        System.out.println("Email     : " + email.getValue(context));

    /* System.out.println("FirstName : " + person.getFirstName());
       System.out.println("LastName  : " + person.getLastName());
       System.out.println("Phone     : " + person.getPhone());
       System.out.println("Email     : " + person.getEmail()); */

       return person;
    }
}

package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;


@Service
public class PersonPrinter {

    @Autowired
    FileConfiguration fileConfiguration ;


    ExpressionParser expressionParser = new SpelExpressionParser();


    public Person printer (Person person){

        Expression forPrinting = expressionParser.parseExpression(fileConfiguration.getPrintFormatPersonExpressionSpEl());

        EvaluationContext context = new StandardEvaluationContext(person);
        System.out.println("");

        System.out.println(forPrinting.getValue(context));

       return person;
    }
}

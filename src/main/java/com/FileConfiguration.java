package com;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class FileConfiguration {

    @Value("${filepaths}")
    @Getter
    @Setter
    private List<String> paths;

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}

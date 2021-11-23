package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotNull(message = "Name cannot be null")
    private String firstName;
    @Min(value = 2)
    @Max(value = 30)
    private String lastName;
    @Pattern(regexp = "(\"^(\\\\+7\\\\d{1,3}( )?)?((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$\")")
    private String phone;
    @Email(message = "Email should be valid")
    private String email;

}

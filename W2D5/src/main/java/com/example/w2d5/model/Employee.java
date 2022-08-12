package com.example.w2d5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Employee {

    @NotNull (message = "ID can not be empty")
    @Range(min = 3, message = "ID can not be less than 3 digit")
    private Integer id;

    @NotEmpty(message = "Name can not be null")
    @Size ( min = 5, message = "Name length must be more than 4")
    private String name;

    @NotNull (message = "Age can not be empty")
    @Positive (message = "Age must be integer number")
    @Min(value = 26, message = "Age should not be less than 26")
    private Integer age;


    private Boolean onLeave = false;

    @NotNull (message = "Field can not be null")
    @Positive (message = "Employment year must be integer number")
    @Range(min = 1960, max = 2022)
    private Integer employmentYear;


    @NotNull (message = "Field can not be null")
    @Positive (message = "Employment year must be integer number")
    @Range(min = 0, max = 1000)
    private Integer annualLeave;


}


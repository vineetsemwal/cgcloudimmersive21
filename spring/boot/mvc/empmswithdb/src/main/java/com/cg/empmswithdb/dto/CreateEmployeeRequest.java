package com.cg.empmswithdb.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Request Data Transfer Object for creating Employee
 */
public class CreateEmployeeRequest {
  @Length(min = 2 , max=10)
    //@NotBlank
    private String name;

   @Max(400000)
   @Min(15000)
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

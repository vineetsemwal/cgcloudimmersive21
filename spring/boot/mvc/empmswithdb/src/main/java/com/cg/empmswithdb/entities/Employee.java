package com.cg.empmswithdb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {

    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private double salary;

    public Employee(){

    }

    public Employee( String name, double salary){
        this.name = name;
        this.salary =salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

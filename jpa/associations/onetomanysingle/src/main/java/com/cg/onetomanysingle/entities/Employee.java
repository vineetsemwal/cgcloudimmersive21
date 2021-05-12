package com.cg.onetomanysingle.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name="employees")
@Entity
public class Employee {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;


    public Employee() {

    }

    public Employee(String name){
        this.name=name;
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

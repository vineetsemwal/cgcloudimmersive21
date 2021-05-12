package com.cg.manytomanysingle.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name="employees")
@Entity
public class Employee {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;

   @ManyToMany
    private List<Department> departments;


    public Employee() {

    }

    public Employee(String name, List<Department> departments){
        this.name=name;
        this.departments=departments;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

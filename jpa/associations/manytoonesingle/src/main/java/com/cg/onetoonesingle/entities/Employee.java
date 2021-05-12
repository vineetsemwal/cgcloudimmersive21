package com.cg.onetoonesingle.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name="employees")
@Entity
public class Employee {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;

    @JoinColumn(name="deptid")
    @ManyToOne
    private  Department department;

    public Employee() {

    }

    public Employee(String name, Department department){
        this.name=name;
        this.department=department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

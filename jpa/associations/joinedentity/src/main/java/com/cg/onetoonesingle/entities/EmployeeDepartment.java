package com.cg.onetoonesingle.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name="employee_department" )
@Entity
public class EmployeeDepartment {

    @GeneratedValue
    @Id
    private Integer id;

    @JoinColumn(name="empid", nullable=false)
    @ManyToOne
    private Employee employee;

    @JoinColumn(name="deptid",nullable = false)
    @ManyToOne
    private Department department;


    public EmployeeDepartment(){

    }

    public EmployeeDepartment(Employee employee,Department department){
        this.employee=employee;
        this.department=department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        EmployeeDepartment that = (EmployeeDepartment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

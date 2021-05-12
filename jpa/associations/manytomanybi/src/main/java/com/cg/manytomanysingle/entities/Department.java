package com.cg.manytomanysingle.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "departments")
@Entity
public class Department {

    @GeneratedValue
    @Id
    private Integer deptId;

    private String deptName;

    @ManyToMany(mappedBy="departments")
    private List<Employee>employees;

    public Department() {

    }

    public Department(String name, List<Employee>employees) {
        this.deptName = name;
        this.employees=employees;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

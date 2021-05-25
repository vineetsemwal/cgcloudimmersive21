package com.cg.empmswithdb.dto;

public class EmployeeDetails {
    private Integer id;
    private String name;
    private double salary;


    public EmployeeDetails(){

    }

    public EmployeeDetails(int id, String name, double salary){
        this.id =id;
        this.name = name;
        this.salary=salary;
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
}

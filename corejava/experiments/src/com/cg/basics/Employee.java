package com.cg.basics;


/**
 * Employee e1=new Employee(1,"krishna",10000);
 * Employee e2=new Employee(2,"prajakta",15000);
 *  Employee e3=new Employee(3,"farheen",30000);
 *  *
 */
public class Employee {

    private int id;

    private String name;

    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

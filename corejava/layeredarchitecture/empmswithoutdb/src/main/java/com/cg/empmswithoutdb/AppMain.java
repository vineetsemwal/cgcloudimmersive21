package com.cg.empmswithoutdb;

import com.cg.empmswithoutdb.entities.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AppMain {

    private HashMap<Integer, Employee> store=new HashMap<>();

    public static void main(String args[]){
        AppMain app=new AppMain();
        app.start();
    }

    int generatedId;

    public int generateId(){
        return ++generatedId;
    }

    public void start(){
        Employee krishna=new Employee("krishna",90000);
        Employee tanvi=new Employee("tanvi",800000);
        addEmployee(krishna);
        addEmployee(tanvi);
        System.out.println("display all employees");
        List<Employee>all= findAll();
        displayEmployees(all);

        System.out.println("find employee by id");
        int tanviId=tanvi.getId();
        Employee fetched=findById(tanviId);
        display(fetched);
    }

    public void addEmployee(Employee employee){
        int newId=generateId();
        employee.setId(newId);
        store.put(newId,employee);
    }

    public Employee findById(int id){
       Employee employee =store.get(id);
       return employee;
    }

    public List<Employee> findAll(){
       Collection<Employee>employees =store.values();
       List<Employee>list=new ArrayList<>(employees);
       return list;
    }

    void display(Employee employee){
        System.out.println(employee.getId()+"-"+employee.getName()+"-"+ employee.getSalary());
    }
    void displayEmployees(Collection<Employee>employees){
        for(Employee emp:employees){
            display(emp);
        }
    }

}

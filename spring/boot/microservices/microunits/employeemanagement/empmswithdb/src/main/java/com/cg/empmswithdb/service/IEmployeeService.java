package com.cg.empmswithdb.service;

import com.cg.empmswithdb.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee add(String name, double salary);

    Employee changeSalary(int empId, double newSalary);

    Employee findById(int empId);

    List<Employee> findAll();

    List<Employee> findEmployeesByName(String name);

    List<Employee> findEmployeesByNameAndSalary(String name, double salary);

    void deleteById(int id);
}

package com.cg.empmswithoutdb.service;

import com.cg.empmswithoutdb.entities.Employee;

public interface IEmployeeService {

    Employee add(String name, double salary);

    Employee changeSalary(int empId, double newSalary);

    Employee findById(int empId);

}

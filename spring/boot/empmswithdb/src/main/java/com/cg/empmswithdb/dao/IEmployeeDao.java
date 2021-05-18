package com.cg.empmswithdb.dao;

import com.cg.empmswithdb.entities.Employee;

import java.util.List;

public interface IEmployeeDao {

    Employee add(Employee employee);

    Employee update(Employee employee );

    Employee findById(int id);

    List<Employee> findAll();


}

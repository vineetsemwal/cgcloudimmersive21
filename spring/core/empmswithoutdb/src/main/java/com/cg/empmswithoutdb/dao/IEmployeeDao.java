package com.cg.empmswithoutdb.dao;

import com.cg.empmswithoutdb.entities.Employee;

import java.util.List;

public interface IEmployeeDao {

    Employee add(Employee employee);

    Employee update(Employee employee );

    Employee findById(int id);

    List<Employee> findAll();

}

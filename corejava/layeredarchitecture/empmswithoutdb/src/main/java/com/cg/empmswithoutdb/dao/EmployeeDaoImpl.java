package com.cg.empmswithoutdb.dao;

import com.cg.empmswithoutdb.entities.Employee;

import java.util.*;

public class EmployeeDaoImpl implements IEmployeeDao{
    private Map<Integer, Employee>store = new HashMap<>();

    private int generatedId;

    int generateId(){
        return ++generatedId;
    }

    @Override
    public Employee add(Employee employee) {
        int newId=generateId();
        employee.setId(newId);
        store.put(newId,employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        int id=employee.getId();
        store.put(id,employee);
        return employee;
    }

    @Override
    public Employee findById(int id) {
        Employee employee =store.get(id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Collection<Employee>employees =store.values();
        List<Employee>list=new ArrayList<>(employees);
        return list;
    }
}

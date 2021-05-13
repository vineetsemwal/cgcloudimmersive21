package com.cg.empmswithoutdb.service;

import com.cg.empmswithoutdb.dao.EmployeeDaoImpl;
import com.cg.empmswithoutdb.dao.IEmployeeDao;
import com.cg.empmswithoutdb.entities.Employee;
import com.cg.empmswithoutdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithoutdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithoutdb.exceptions.InvalidSalaryException;

public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDao dao=new EmployeeDaoImpl();

    @Override
    public Employee add(String name, double salary) {
        validateName(name);
        validateSalary(salary);
        Employee employee=new Employee(name, salary);
        Employee saved =dao.add(employee);
        return saved;
    }


    @Override
    public Employee findById(int empId) {
        validateId(empId);
       Employee employee= dao.findById(empId);
       return employee;
    }

    @Override
    public Employee changeSalary(int empId, double newSalary) {
        validateId(empId);
        validateSalary(newSalary);
        Employee employee=dao.findById(empId);
        Employee saved=dao.update(employee);
        return saved ;
    }


    void validateId(int id){
        if(id<0){
            throw new InvalidEmployeeIdException("id can't be negative");
        }
    }

    void validateName(String name){
        if(name==null || name.isEmpty()){
            throw new InvalidEmployeeNameException("name can't be null or empty");
        }

    }
    void validateSalary(double salary){
        if(salary<0){
            throw new InvalidSalaryException("salary can't be negative");
        }

    }


}

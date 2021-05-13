package com.cg.empmswithdb.service;

import com.cg.empmswithdb.dao.EmployeeDaoImpl;
import com.cg.empmswithdb.dao.IEmployeeDao;
import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithdb.exceptions.InvalidSalaryException;
import com.cg.empmswithdb.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDao dao;

    private EntityManager entityManager;

    public EmployeeServiceImpl(){
        JpaUtil jpaUtil=JpaUtil.getInstance();
        entityManager=jpaUtil.newEntityManager();
        dao=new EmployeeDaoImpl(entityManager);
    }

    @Override
    public Employee add(String name, double salary) {
        validateName(name);
        validateSalary(salary);
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Employee employee=new Employee(name, salary);
        Employee saved =dao.add(employee);
        transaction.commit();
        return saved;
    }


    @Override
    public Employee findById(int empId) {
        validateId(empId);
         Employee employee= dao.findById(empId);
       return employee;
    }

    @Override
    public List<Employee> findAll() {
       List<Employee>list= dao.findAll();
       return list;
    }

    @Override
    public Employee changeSalary(int empId, double newSalary) {
        validateId(empId);
        validateSalary(newSalary);
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Employee employee=dao.findById(empId);
        employee.setSalary(newSalary);
        Employee saved=dao.update(employee);
        transaction.commit();
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

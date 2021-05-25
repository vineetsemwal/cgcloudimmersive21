package com.cg.empmswithdb.service;

import com.cg.empmswithdb.dao.IEmployeeRepository;
import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.exceptions.EmployeeNotFoundException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithdb.exceptions.InvalidSalaryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository dao;


    @Override
    public Employee add(String name, double salary) {
        validateName(name);
        validateSalary(salary);
        Employee employee = new Employee(name, salary);
        Employee saved = dao.save(employee);//works like merge() in entitymanager
        return saved;
    }


    @Override
    public Employee findById(int empId) {
        validateId(empId);
        Optional<Employee> optional = dao.findById(empId);

        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("employee not found for id=" + empId);
        }

        return optional.get();

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = dao.findAll();
        return list;
    }

    /**
     *
     *  finds all the employees by name
     *
     * @param name  name for which employees has to be searched
     * @return List<Employee>  list of employees found
     */
    @Override
    public List<Employee> findEmployeesByName(String name) {
        validateName(name);
        List<Employee> list = dao.findByName(name);
        return list;
    }

    @Override
    public List<Employee> findEmployeesByNameAndSalary(String name, double salary) {
        validateName(name);
        List<Employee> list = dao.findByNameAndSalary(name, salary);
        return list;
    }

    @Override
    public Employee changeSalary(int empId, double newSalary) {
        validateId(empId);
        validateSalary(newSalary);
        Employee employee = findById(empId);
        employee.setSalary(newSalary);
        Employee saved = dao.save(employee);
        return saved;
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);

    }

    void validateId(int id) {
        if (id < 0) {
            throw new InvalidEmployeeIdException("id can't be negative");
        }
    }

    void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeNameException("name can't be null or empty");
        }

    }

    void validateSalary(double salary) {
        if (salary < 0) {
            throw new InvalidSalaryException("salary can't be negative");
        }

    }


}

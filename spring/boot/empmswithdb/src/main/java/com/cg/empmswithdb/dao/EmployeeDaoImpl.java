package com.cg.empmswithdb.dao;

import com.cg.empmswithdb.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Employee add(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee saved=entityManager.merge(employee);
        return saved;
    }

    @Override
    public Employee findById(int id) {
        Employee employee =entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        String qlText="from Employee";
        TypedQuery<Employee>query= entityManager.createQuery(qlText,Employee.class);
        List<Employee>list= query.getResultList();
        return list;
    }

}

package com.cg.jpademo;

import com.cg.jpademo.entities.Department;
import com.cg.jpademo.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaExperiment2 {

    private EntityManager entityManager;

    public static void main(String args[]) {
        JpaExperiment2 experiment = new JpaExperiment2();
        experiment.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emp-ms");
        entityManager = emf.createEntityManager();
        Employee krishna = new Employee("krishna", 20000);
        Employee prajakta = new Employee("prajakta", 30000);
        add(krishna);
        add(krishna);
        add(prajakta);

        krishna.setBalance(90000);
        update(krishna);

        Employee fetched = findEmployeeById(krishna.getId());
        display(fetched);

        Employee tanvi=new Employee("tanvi",900000);
        tanvi=add2(tanvi);
        tanvi.setName("tanvi dalvi");
        add2(tanvi);

        Department dev=new Department(10,"dev");
        add(dev);
        Department testing=new Department(11,"testing");
        add(testing);

        emf.close();
    }

    void display(Employee employee) {
        System.out.println("fetched object details=" + employee.getId() + " -" + employee.getName() + "-" + employee.getBalance());

    }


    public Employee add2(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        employee=entityManager.merge(employee);
        transaction.commit();
        return employee;
    }

    public void update(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
    }

    public Employee findEmployeeById(int id) {
        Employee fetched = entityManager.find(Employee.class, id);
        return fetched;
    }

    public void add(Department department){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(department);// will insert a row in table
        transaction.commit();
    }

    public void add(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);// will insert a row in table if id in object doesn't exist in table
        transaction.commit();
    }

}

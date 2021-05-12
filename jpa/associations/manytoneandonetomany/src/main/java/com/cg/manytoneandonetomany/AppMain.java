package com.cg.manytoneandonetomany;

import com.cg.manytoneandonetomany.entities.Department;
import com.cg.manytoneandonetomany.entities.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class AppMain {

    private EntityManager entityManager;

    public static void main(String args[]){
        AppMain app = new AppMain();
        app.start();
    }

    public void start(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("emp-ms");
        entityManager=emf.createEntityManager();
        EntityTransaction transaction1= entityManager.getTransaction();
        transaction1.begin();
        Department dev=new Department("dev",new ArrayList<>());
        Department test=new Department("test",new ArrayList<>());
        entityManager.persist(dev);
        entityManager.persist(test);

        Employee venkatesh=new  Employee("venkatesh",dev);
        entityManager.persist(venkatesh);
        Employee chaitanya=new  Employee("chaitanya",dev);
        entityManager.persist(chaitanya);

        List<Employee> devEmployees=new ArrayList<>();
        devEmployees.add(chaitanya);
        devEmployees.add(venkatesh);
        dev.setEmployees(devEmployees);
     //   entityManager.merge(dev);
        transaction1.commit();

        EntityTransaction transaction2=entityManager.getTransaction();
        transaction2.begin();
        Employee prachi=new Employee("prachi",test);
        Employee tanvi=new Employee("tanvi",test);
        entityManager.persist(prachi);
        entityManager.persist(tanvi);
        List<Employee>testEmployees=new ArrayList<>();
        testEmployees.add(prachi);
        testEmployees.add(tanvi);
        test.setEmployees(testEmployees);
       // entityManager.merge(test);
        transaction2.commit();

        System.out.println("fetching employee and his depermant");
        int prachiId=prachi.getId();
        Employee desiredEmployee=entityManager.find(Employee.class,prachiId);
        display(desiredEmployee);

        Department associatedDept=desiredEmployee.getDepartment();
        display(associatedDept);

        System.out.println("fetching dev department and associated employees");
        int devDeptId=dev.getDeptId();
        Department found=entityManager.find(Department.class,devDeptId);
        List<Employee>associatedEmployees=found.getEmployees();
        display(found);
        for (Employee emp:associatedEmployees){
            display(emp);
        }
        entityManager.close();
        emf.close();
    }

    void display(Department department){
        System.out.println(department.getDeptId()+"-"+department.getDeptName());
    }

    void  display(Employee employee){
        System.out.println(employee.getId()+"-"+employee.getName());
    }



}

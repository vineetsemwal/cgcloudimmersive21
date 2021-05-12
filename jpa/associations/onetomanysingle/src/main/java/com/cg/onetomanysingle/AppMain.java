package com.cg.onetomanysingle;

import com.cg.onetomanysingle.entities.Department;
import com.cg.onetomanysingle.entities.Employee;

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
        Employee venkatesh=new  Employee("venkatesh");
        entityManager.persist(venkatesh);
        Employee chaitanya=new  Employee("chaitanya");
        entityManager.persist(chaitanya);
        List<Employee> devEmployees=new ArrayList<>();
        devEmployees.add(chaitanya);
        devEmployees.add(venkatesh);
        Department devDept=new Department("dev",devEmployees);
        entityManager.persist(devDept);
        transaction1.commit();

        EntityTransaction transaction2=entityManager.getTransaction();
        transaction2.begin();
        Employee prachi=new Employee("prachi");
        Employee tanvi=new Employee("tanvi");
        entityManager.persist(prachi);
        entityManager.persist(tanvi);
        List<Employee>testEmployees=new ArrayList<>();
        testEmployees.add(prachi);
        testEmployees.add(tanvi);
        Department testing=new Department("testing",testEmployees);
        entityManager.persist(testing);
        transaction2.commit();

        System.out.println("fetching dev department and asscoiated employees");
        int devDeptId=devDept.getDeptId();
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

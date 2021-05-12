package com.cg.onetoonesingle;

import com.cg.onetoonesingle.entities.Department;
import com.cg.onetoonesingle.entities.Employee;

import javax.persistence.*;
public class AppMain {

    private EntityManager entityManager;

    public static void main(String args[]){
        AppMain app = new AppMain();
        app.start();
    }

    public void start(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("emp-ms");
        entityManager=emf.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        Department dept=new Department("dev");
        entityManager.persist(dept);
        Employee employee=new  Employee("venkatesh", dept);
        entityManager.persist(employee);
        transaction.commit();
        int empId=employee.getId();
        Employee found=entityManager.find(Employee.class,empId);
        display(found);
        Department associatedDept=found.getDepartment();
        display(associatedDept);

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

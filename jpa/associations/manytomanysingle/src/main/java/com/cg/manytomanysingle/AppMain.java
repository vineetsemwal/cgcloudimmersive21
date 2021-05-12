package com.cg.manytomanysingle;

import com.cg.manytomanysingle.entities.Department;
import com.cg.manytomanysingle.entities.Employee;

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
        Department dev=new Department("dev");
        Department test=new Department("test");
        Department devops=new Department("devops");
        entityManager.persist(dev);
        entityManager.persist(test);
        entityManager.persist(devops);

        List<Department>venkyDepts=new ArrayList<>();
        venkyDepts.add(dev);
        venkyDepts.add(test);
        Employee venkatesh=new  Employee("venkatesh",venkyDepts);
        entityManager.persist(venkatesh);

        List<Department>chaitanyaDepts=new ArrayList<>();
        chaitanyaDepts.add(devops);
        chaitanyaDepts.add(test);
        Employee chaitanya=new  Employee("chaitanya",chaitanyaDepts);
        entityManager.persist(chaitanya);
         transaction1.commit();

       System.out.println("fetch employee and his associated departments");
        int venkateshId=venkatesh.getId();
        Employee desiredEmployee=entityManager.find(Employee.class,venkateshId);
        display(desiredEmployee);

        List<Department>associatedDepts=desiredEmployee.getDepartments();
        for (Department dept:associatedDepts){
            display(dept);
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

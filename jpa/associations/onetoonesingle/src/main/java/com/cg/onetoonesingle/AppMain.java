package com.cg.onetoonesingle;

import com.cg.onetoonesingle.entities.Address;
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
        Address address=new Address("hyderabad","reliance one");
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(address);
        Employee employee=new Employee("krishna",address);
        entityManager.persist(employee);
        transaction.commit();
        int employeeId=employee.getId();
        Employee found=entityManager.find(Employee.class,employeeId);
        Address foundAddress=found.getAddress();
        display(found);
        display(foundAddress);
        entityManager.close();
        emf.close();
    }

    void  display(Employee employee){
        System.out.println(employee.getId()+"-"+employee.getName());
    }

    void display(Address address ){
        System.out.println(address.getAddressId()+"-"+address.getCity()+"-"+address.getBuilding());
    }

}

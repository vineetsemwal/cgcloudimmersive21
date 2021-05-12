package com.cg.onetoonebi;

import com.cg.onetoonebi.entities.Address;
import com.cg.onetoonebi.entities.Employee;

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
        int addressId=address.getAddressId();
        Employee employee=new Employee("krishna",address);
        entityManager.persist(employee);

        address.setEmployee(employee);
        entityManager.merge(address);

        transaction.commit();
        int employeeId=employee.getId();
        System.out.println("fetching employee and its associated address");
        Employee found=entityManager.find(Employee.class,employeeId);
        Address foundAddress=found.getAddress();
        display(found);
        display(foundAddress);

        System.out.println("*****fetching address and its asscoiated employee");
        Address desiredAddress=entityManager.find(Address.class,addressId);
        display(desiredAddress);
        Employee desiredEmployee=desiredAddress.getEmployee();
        display(desiredEmployee);

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

package com.cg.jpademo;

import com.cg.jpademo.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaExperiment1 {

    private EntityManager entityManager;

    public static void main(String args[]) {
        JpaExperiment1 experiment=new JpaExperiment1();
        experiment.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emp-ms");
        entityManager = emf.createEntityManager();
        Employee krishna=new Employee("krishna",20000);
        Employee prajakta=new Employee("prajakta", 30000);
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(krishna);// will insert a row in table
        entityManager.persist(prajakta);// will insert a row in table

        transaction.commit();
        System.out.println("details for krishna inserted with id="+krishna.getId());
        System.out.println("details for prajakta inserted with id="+prajakta.getId());
        int prajaktaId=prajakta.getId();
        Employee fetched=entityManager.find(Employee.class,prajaktaId);
        System.out.println("fetched object details="+fetched.getId()+" -"+fetched.getName()+"-"+fetched.getBalance());

         transaction=entityManager.getTransaction();
         transaction.begin();
         prajakta.setBalance(50000);
         prajakta.setName("prajakta deshmukh");
         //
        //merge has 2 operations , one is updating previously existing row another is inserting new row if
        // primary field of object does not exist in the table
        //
         entityManager.merge(prajakta);
         transaction.commit();
         System.out.println("balance updated for prajakta");


        emf.close();
    }


}

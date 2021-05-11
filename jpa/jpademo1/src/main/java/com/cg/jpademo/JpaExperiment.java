package com.cg.jpademo;

import com.cg.jpademo.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaExperiment {

    private EntityManager entityManager;

    public static void main(String args[]) {
        JpaExperiment experiment=new JpaExperiment();
        experiment.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emp-ms");
        entityManager = emf.createEntityManager();
        Employee krishna=new Employee("krishna",20000);
        Employee prajakta=new Employee("prajakta", 30000);
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(krishna);// will insert as row in table
        entityManager.persist(prajakta);
        transaction.commit();
        System.out.println("details for krishna inserted with id="+krishna.getId());
        System.out.println("details for prajakta inserted with id="+prajakta.getId());

    }


}

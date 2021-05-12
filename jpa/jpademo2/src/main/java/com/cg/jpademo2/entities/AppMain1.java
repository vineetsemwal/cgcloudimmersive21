package com.cg.jpademo2.entities;

import javax.persistence.*;

public class AppMain1 {

    private EntityManager entityManager;

    public static void main(String args[]){
       AppMain1 app=new AppMain1();
        app.start();
    }

    public void  start(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("school-ms");
        entityManager=emf.createEntityManager();
        EntityTransaction transaction1=entityManager.getTransaction();
        transaction1.begin();
        Student krishna=new Student("krishna",21);
        Student venkat=new Student("venkat",22);
        entityManager.persist(krishna);
        entityManager.persist(venkat);
        transaction1.commit();
        System.out.println("krishna inserted with id="+krishna.getId());
        System.out.println("venkat inserted with id="+ venkat.getId());
        int krishnaId=krishna.getId();
        Student found=entityManager.find(Student.class,krishnaId);
        System.out.println("found object="+found.getId()+"-"+found.getName()+"-"+found.getAge());

        EntityTransaction transaction2=entityManager.getTransaction();
        transaction2.begin();
        krishna.setName("shivakrishna");
        entityManager.merge(krishna);
        transaction2.commit();
        System.out.println("krishna changes updated");

        EntityTransaction transaction3=entityManager.getTransaction();
        transaction3.begin();
        Student raju=new Student("raju",22);
        entityManager.merge(raju);
        transaction3.commit();
        System.out.println("raju object doesn't have id in table so it will cause insertion of new row ");


        EntityTransaction transaction4=entityManager.getTransaction();
        transaction4.begin();
        entityManager.remove(krishna);
        transaction4.commit();

        entityManager.close();
        emf.close();

    }

}

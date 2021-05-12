package com.cg.jpademo2.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppMain2 {

    private EntityManager entityManager;

    public static void main(String args[]) {
        AppMain2 app = new AppMain2();
        app.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-ms");
        entityManager = emf.createEntityManager();
        Student krishna = new Student("krishna", 21);
        Student venkat = new Student("venkat", 22);
        add(krishna);
        add(venkat);
        System.out.println("krishna inserted with id=" + krishna.getId());
        System.out.println("venkat inserted with id=" + venkat.getId());
        int krishnaId = krishna.getId();
        Student found = findById(krishnaId);
        display(found);
        krishna.setName("sivakrishna");
        krishna=update(krishna);
        System.out.println("krishna changes updated");
        display(krishna);

        remove(krishna);
        System.out.println("krishna removed");
        entityManager.close();
        emf.close();

    }

    public void add(Student student) {
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        entityManager.persist(student);
        transaction1.commit();
    }

    public Student update(Student student){
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        Student saved=entityManager.merge(student);
        transaction1.commit();
        return saved;
    }


    public void remove(Student student){
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        entityManager.remove(student);
        transaction1.commit();
    }

    public Student findById(int id){
       Student student= entityManager.find(Student.class,id);
       return student;
    }

    public void display(Student student){
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());

    }


}

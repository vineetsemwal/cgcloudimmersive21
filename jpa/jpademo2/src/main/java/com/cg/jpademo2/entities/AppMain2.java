package com.cg.jpademo2.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
        Student tanvi = new Student("tanvi", 23);

        add(krishna);
        add(venkat);
        add(tanvi);
        System.out.println("krishna inserted with id=" + krishna.getId());
        System.out.println("venkat inserted with id=" + venkat.getId());
        int krishnaId = krishna.getId();
        Student found = findById(krishnaId);
        display(found);
        krishna.setName("sivakrishna");
        krishna=update(krishna);
        System.out.println("krishna changes updated");
        display(krishna);

        System.out.println("***fetch and splay all students");
       List<Student>all= fetchAll();
        displayCollection(all);

        System.out.println("***fetch and display all students with age greater than 21");
        List<Student>allGreaterThan21=fetchAllGreaterthan21();
        displayCollection(allGreaterThan21);
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


    public List<Student> fetchAll(){
        String queryText="from Student";
        TypedQuery<Student> query=entityManager.createQuery(queryText,Student.class);
        List<Student>list =query.getResultList();
        return list;
    }

    public List<Student> fetchAllGreaterthan21(){
        String queryText="from Student where age>21";
        TypedQuery<Student> query=entityManager.createQuery(queryText,Student.class);
        List<Student>list =query.getResultList();
        return list;
    }

    public void display(Student student){
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());

    }
    public void displayCollection(Collection<Student> students){
        for(Student  student:students){
            display(student);
        }
    }



}
